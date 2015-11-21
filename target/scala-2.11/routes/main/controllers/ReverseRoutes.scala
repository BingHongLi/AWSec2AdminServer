
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/cirrusdi/AwsEc2AdminServer/conf/routes
// @DATE:Sat Nov 21 09:59:33 CST 2015

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:12
package controllers {

  // @LINE:31
  class ReverseTest(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:31
    def test(id:String, value:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "tdd&id=" + implicitly[PathBindable[String]].unbind("id", id) + "&value=" + implicitly[PathBindable[String]].unbind("value", value))
    }
  
  }

  // @LINE:18
  class ReverseQuery(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def getWPqueryEC2Info(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "queryEC2Info")
    }
  
    // @LINE:19
    def postReturnEC2Info(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "queryEC2Info")
    }
  
  }

  // @LINE:12
  class ReverseApplication(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def restartInstance(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "restartInstance")
    }
  
    // @LINE:12
    def getIp(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "getIp")
    }
  
    // @LINE:27
    def backupInstanceEBS(describe:String, snapshotTag:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "backupEBS&describe=" + implicitly[PathBindable[String]].unbind("describe", describe) + "&snapshotTag=" + implicitly[PathBindable[String]].unbind("snapshotTag", snapshotTag))
    }
  
  }


}