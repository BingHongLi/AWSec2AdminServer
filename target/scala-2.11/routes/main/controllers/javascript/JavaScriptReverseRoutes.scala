
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/cirrusdi/testPlay/conf/routes
// @DATE:Mon Nov 02 20:59:24 CST 2015

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:12
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:18
  class ReverseQuery(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def getWPqueryEC2Info: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Query.getWPqueryEC2Info",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "queryEC2Info"})
        }
      """
    )
  
    // @LINE:23
    def test2: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Query.test2",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "test2"})
        }
      """
    )
  
    // @LINE:19
    def postReturnEC2Info: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Query.postReturnEC2Info",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "queryEC2Info"})
        }
      """
    )
  
    // @LINE:22
    def test: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Query.test",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "test"})
        }
      """
    )
  
  }

  // @LINE:12
  class ReverseApplication(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def restartInstance: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.restartInstance",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "restartInstance"})
        }
      """
    )
  
    // @LINE:12
    def getIp: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.getIp",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getIp"})
        }
      """
    )
  
  }


}