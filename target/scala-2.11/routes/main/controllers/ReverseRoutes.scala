
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/cirrusdi/AwsEc2AdminServer/conf/routes
// @DATE:Sat Nov 21 17:30:16 CST 2015

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:12
package controllers {

  // @LINE:34
  class ReverseTest(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:34
    def test(id:String, value:String): Call = {
    
      (id: @unchecked, value: @unchecked) match {
      
        // @LINE:34
        case (id, value)  =>
          import ReverseRouteContext.empty
          Call("GET", _prefix + { _defaultPrefix } + "tdd&id=" + implicitly[PathBindable[String]].unbind("id", id) + "&value=" + implicitly[PathBindable[String]].unbind("value", value))
      
      }
    
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

  
    // @LINE:30
    def backupInstanceEBS(regionEndpoint:String = "ec2.ap-northeast-1.amazonaws.com" , describe:String, snapshotTag:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "backupEBS" + queryString(List(if(regionEndpoint == "ec2.ap-northeast-1.amazonaws.com" ) None else Some(implicitly[QueryStringBindable[String]].unbind("regionEndpoint", regionEndpoint)), Some(implicitly[QueryStringBindable[String]].unbind("describe", describe)), Some(implicitly[QueryStringBindable[String]].unbind("snapshotTag", snapshotTag)))))
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