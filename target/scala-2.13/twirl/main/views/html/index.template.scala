
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,org.webjars.play.WebJarsUtil,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(webSocketUrl: String)(implicit webJarsUtil: org.webjars.play.WebJarsUtil):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        """),_display_(/*9.10*/webJarsUtil/*9.21*/.locate("bootstrap.min.css").css()),format.raw/*9.55*/("""
        """),_display_(/*10.10*/webJarsUtil/*10.21*/.locate("bootstrap-theme.min.css").css()),format.raw/*10.61*/("""

        """),format.raw/*12.9*/("""<link rel="stylesheet" media="screen" href=""""),_display_(/*12.54*/routes/*12.60*/.Assets.at("stylesheets/main.css")),format.raw/*12.94*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*13.59*/routes/*13.65*/.Assets.at("images/favicon.png")),format.raw/*13.97*/("""">
        <title>Chat Room</title>

    </head>

    <body>
        <div class="wrap">
            <div class="container-fluid">
                <div>
                    <h1 class="">Chat Room</h1>
                </div>

                <div class="row">
                    <div class="col-lg-12">
                        <ul id="messages" class="list-unstyled">
                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <div class="footer navbar-fixed-bottom">
            <div class="row">
                <div class="col-xs-8 col-sm-9">
                    <input id="message" placeholder="Type Here" type="text"
                      autofocus
                      autocomplete="off" spellcheck="false" autocorrect="off"
                      class="form-control input-lg" />
                </div>

                <div class="col-xs-4 col-sm-3">
                    <button id="send" type="submit" class="btn btn-primary btn-lg btn-block">Send</button>
                </div>
            </div>
        </div>

        """),_display_(/*49.10*/webJarsUtil/*49.21*/.locate("jquery.min.js").script()),format.raw/*49.54*/("""
        """),_display_(/*50.10*/webJarsUtil/*50.21*/.locate("jquery.flot.min.js").script()),format.raw/*50.59*/("""
        """),format.raw/*51.9*/("""<script type='text/javascript' src='"""),_display_(/*51.46*/routes/*51.52*/.Assets.at("javascripts/modernizr-3.5.0.js")),format.raw/*51.96*/("""'></script>
        <script type='text/javascript' src='"""),_display_(/*52.46*/routes/*52.52*/.Assets.at("javascripts/app.js")),format.raw/*52.84*/("""' data-url='"""),_display_(/*52.97*/webSocketUrl),format.raw/*52.109*/("""'></script>

    </body>

</html>"""))
      }
    }
  }

  def render(webSocketUrl:String,webJarsUtil:org.webjars.play.WebJarsUtil): play.twirl.api.HtmlFormat.Appendable = apply(webSocketUrl)(webJarsUtil)

  def f:((String) => (org.webjars.play.WebJarsUtil) => play.twirl.api.HtmlFormat.Appendable) = (webSocketUrl) => (webJarsUtil) => apply(webSocketUrl)(webJarsUtil)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-01-15T15:59:14.539
                  SOURCE: /Users/springchan/scala/play-samples-play-scala-chatroom-example/app/views/index.scala.html
                  HASH: 3405918bd742d856734da2556e4d59762a45cbe9
                  MATRIX: 758->1|926->76|1176->300|1195->311|1249->345|1286->355|1306->366|1367->406|1404->416|1476->461|1491->467|1546->501|1634->562|1649->568|1702->600|2825->1696|2845->1707|2899->1740|2936->1750|2956->1761|3015->1799|3051->1808|3115->1845|3130->1851|3195->1895|3279->1952|3294->1958|3347->1990|3387->2003|3421->2015
                  LINES: 21->1|26->2|33->9|33->9|33->9|34->10|34->10|34->10|36->12|36->12|36->12|36->12|37->13|37->13|37->13|73->49|73->49|73->49|74->50|74->50|74->50|75->51|75->51|75->51|75->51|76->52|76->52|76->52|76->52|76->52
                  -- GENERATED --
              */
          