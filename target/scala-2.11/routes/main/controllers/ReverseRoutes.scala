
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/cirrusdi/testPlay/conf/routes
// @DATE:Sun Nov 01 10:53:30 CST 2015

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:12
package controllers {

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
  
    // @LINE:23
    def test2(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "test2")
    }
  
    // @LINE:19
    def postReturnEC2Info(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "queryEC2Info")
    }
  
    // @LINE:22
    def test(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "test")
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
  
  }


}