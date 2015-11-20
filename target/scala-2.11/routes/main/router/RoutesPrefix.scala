
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/cirrusdi/AwsEc2AdminServer/conf/routes
// @DATE:Sat Nov 21 01:03:12 CST 2015


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
