// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/springchan/scala/simple-chat-room/conf/routes
// @DATE:Wed Jan 15 17:32:42 CST 2020


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
