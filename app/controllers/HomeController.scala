package controllers

import javax.inject._
import akka.actor.ActorSystem
import akka.event.Logging
import akka.stream.Materializer
import akka.stream.scaladsl.{BroadcastHub, Flow, Keep, MergeHub, Source}
import play.api.Logger
import play.api.mvc._
import play.api.libs.json._

import scala.collection.mutable.ListBuffer
import scala.concurrent.{ExecutionContext, Future}

/**
 * A very simple chat client using websockets.
 */
@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents, inputSanitizer: InputSanitizer)
                              (implicit actorSystem: ActorSystem,
                               mat: Materializer,
                               executionContext: ExecutionContext,
                               webJarsUtil: org.webjars.play.WebJarsUtil)
                               extends BaseController with RequestMarkerContext {

  private type WSMessage = String

  private val history = new ListBuffer[String]

  private val logger = Logger(getClass)

  private implicit val logging = Logging(actorSystem.eventStream, logger.underlyingLogger.getName)

  private val (chatSink, chatSource) = {
    val source = MergeHub.source[WSMessage]
      .log("source",(s: String) => persistLog(s))
      .map(inputSanitizer.sanitize)
      .recoverWithRetries(-1, { case _: Exception => Source.empty })


    val sink = BroadcastHub.sink[WSMessage]
    source.toMat(sink)(Keep.both).run()
  }

  private val userFlow: Flow[WSMessage, WSMessage, _] = {
    Flow.fromSinkAndSource(chatSink, chatSource)
  }

  /**
   * 首页
   * @return
   */
  def index: Action[AnyContent] = Action { implicit request: RequestHeader =>
    val webSocketUrl = routes.HomeController.chat().webSocketURL()
    logger.info(s"index: ")
    Ok(views.html.index(webSocketUrl))
  }

  /**
   * Web socket
   * @return
   */
  def chat(): WebSocket = {
    WebSocket.acceptOrResult[WSMessage, WSMessage] {
      case _ =>
        Future.successful(userFlow).map { flow =>
          Right(flow)
        }.recover {
          case e: Exception =>
            val msg = "Cannot create websocket"
            logger.error(msg, e)
            val result = InternalServerError(msg)
            Left(result)
        }
    }
  }

  /**
   * 聊天记录
   * @return
   */
  def chatHistory() = Action {
    implicit request: RequestHeader =>
      val json: JsValue = Json.obj(
        "history" -> history.takeRight(20).toList
      )
      Ok(json)
  }

  // 存放聊天记录
  private def persistLog(s: String): String = {
    if (s == "") {
      return "心跳"
    }
    history += s
    if (history.size > 40) {
      logger.warn("清除历史记录")
      history.remove(0, 20)
    }
    s
  }
}
