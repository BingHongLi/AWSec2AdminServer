
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/cirrusdi/AwsEc2AdminServer/conf/routes
// @DATE:Sat Nov 21 09:59:33 CST 2015

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:12
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:31
  class ReverseTest(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:31
    def test: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Test.test",
      """
        function(id,value) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tdd&id=" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", id) + "&value=" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("value", value)})
        }
      """
    )
  
  }

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
  
    // @LINE:19
    def postReturnEC2Info: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Query.postReturnEC2Info",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "queryEC2Info"})
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
  
    // @LINE:27
    def backupInstanceEBS: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.backupInstanceEBS",
      """
        function(describe,snapshotTag) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "backupEBS&describe=" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("describe", describe) + "&snapshotTag=" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("snapshotTag", snapshotTag)})
        }
      """
    )
  
  }


}