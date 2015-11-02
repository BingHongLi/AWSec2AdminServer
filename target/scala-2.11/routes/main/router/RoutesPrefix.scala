
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/cirrusdi/testPlay/conf/routes
// @DATE:Mon Nov 02 20:59:24 CST 2015


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
