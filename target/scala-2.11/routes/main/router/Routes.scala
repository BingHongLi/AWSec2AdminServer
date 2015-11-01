
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/cirrusdi/testPlay/conf/routes
// @DATE:Sun Nov 01 10:53:30 CST 2015

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:12
  Application_0: controllers.Application,
  // @LINE:18
  Query_1: controllers.Query,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:12
    Application_0: controllers.Application,
    // @LINE:18
    Query_1: controllers.Query
  ) = this(errorHandler, Application_0, Query_1, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Application_0, Query_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getIp""", """controllers.Application.getIp()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """restartInstance""", """controllers.Application.restartInstance()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """queryEC2Info""", """controllers.Query.getWPqueryEC2Info()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """queryEC2Info""", """controllers.Query.postReturnEC2Info()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """test""", """controllers.Query.test()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """test2""", """controllers.Query.test2()"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:12
  private[this] lazy val controllers_Application_getIp0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getIp")))
  )
  private[this] lazy val controllers_Application_getIp0_invoker = createInvoker(
    Application_0.getIp(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "getIp",
      Nil,
      "GET",
      """ 取得使用者ip""",
      this.prefix + """getIp"""
    )
  )

  // @LINE:15
  private[this] lazy val controllers_Application_restartInstance1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("restartInstance")))
  )
  private[this] lazy val controllers_Application_restartInstance1_invoker = createInvoker(
    Application_0.restartInstance(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "restartInstance",
      Nil,
      "GET",
      """ 重啟ec2 instance, 供更換ip使用""",
      this.prefix + """restartInstance"""
    )
  )

  // @LINE:18
  private[this] lazy val controllers_Query_getWPqueryEC2Info2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("queryEC2Info")))
  )
  private[this] lazy val controllers_Query_getWPqueryEC2Info2_invoker = createInvoker(
    Query_1.getWPqueryEC2Info(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Query",
      "getWPqueryEC2Info",
      Nil,
      "GET",
      """ 查詢EC2 Instance Info""",
      this.prefix + """queryEC2Info"""
    )
  )

  // @LINE:19
  private[this] lazy val controllers_Query_postReturnEC2Info3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("queryEC2Info")))
  )
  private[this] lazy val controllers_Query_postReturnEC2Info3_invoker = createInvoker(
    Query_1.postReturnEC2Info(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Query",
      "postReturnEC2Info",
      Nil,
      "POST",
      """""",
      this.prefix + """queryEC2Info"""
    )
  )

  // @LINE:22
  private[this] lazy val controllers_Query_test4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("test")))
  )
  private[this] lazy val controllers_Query_test4_invoker = createInvoker(
    Query_1.test(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Query",
      "test",
      Nil,
      "GET",
      """ 測試功能用""",
      this.prefix + """test"""
    )
  )

  // @LINE:23
  private[this] lazy val controllers_Query_test25_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("test2")))
  )
  private[this] lazy val controllers_Query_test25_invoker = createInvoker(
    Query_1.test2(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Query",
      "test2",
      Nil,
      "POST",
      """""",
      this.prefix + """test2"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:12
    case controllers_Application_getIp0_route(params) =>
      call { 
        controllers_Application_getIp0_invoker.call(Application_0.getIp())
      }
  
    // @LINE:15
    case controllers_Application_restartInstance1_route(params) =>
      call { 
        controllers_Application_restartInstance1_invoker.call(Application_0.restartInstance())
      }
  
    // @LINE:18
    case controllers_Query_getWPqueryEC2Info2_route(params) =>
      call { 
        controllers_Query_getWPqueryEC2Info2_invoker.call(Query_1.getWPqueryEC2Info())
      }
  
    // @LINE:19
    case controllers_Query_postReturnEC2Info3_route(params) =>
      call { 
        controllers_Query_postReturnEC2Info3_invoker.call(Query_1.postReturnEC2Info())
      }
  
    // @LINE:22
    case controllers_Query_test4_route(params) =>
      call { 
        controllers_Query_test4_invoker.call(Query_1.test())
      }
  
    // @LINE:23
    case controllers_Query_test25_route(params) =>
      call { 
        controllers_Query_test25_invoker.call(Query_1.test2())
      }
  }
}