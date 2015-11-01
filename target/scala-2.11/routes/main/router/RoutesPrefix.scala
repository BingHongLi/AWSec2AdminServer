
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/cirrusdi/testPlay/conf/routes
// @DATE:Sun Nov 01 10:53:30 CST 2015


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
