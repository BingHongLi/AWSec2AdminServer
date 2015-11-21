
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/cirrusdi/AwsEc2AdminServer/conf/routes
// @DATE:Sat Nov 21 17:30:16 CST 2015

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
  Query_2: controllers.Query,
  // @LINE:34
  Test_1: controllers.Test,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:12
    Application_0: controllers.Application,
    // @LINE:18
    Query_2: controllers.Query,
    // @LINE:34
    Test_1: controllers.Test
  ) = this(errorHandler, Application_0, Query_2, Test_1, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Application_0, Query_2, Test_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getIp""", """controllers.Application.getIp()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """restartInstance""", """controllers.Application.restartInstance()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """queryEC2Info""", """controllers.Query.getWPqueryEC2Info()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """queryEC2Info""", """controllers.Query.postReturnEC2Info()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """backupEBS""", """controllers.Application.backupInstanceEBS(regionEndpoint:String ?= "ec2.ap-northeast-1.amazonaws.com" , describe:String, snapshotTag:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tdd&id=$id<(\w+)>&value=$value<(\w+)>""", """controllers.Test.test(id:String, value:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """clients""", """controllers.Test.test(id:String ?= "cdda" , value:String)"""),
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
    Query_2.getWPqueryEC2Info(),
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
    Query_2.postReturnEC2Info(),
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

  // @LINE:30
  private[this] lazy val controllers_Application_backupInstanceEBS4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("backupEBS")))
  )
  private[this] lazy val controllers_Application_backupInstanceEBS4_invoker = createInvoker(
    Application_0.backupInstanceEBS(fakeValue[String], fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "backupInstanceEBS",
      Seq(classOf[String], classOf[String], classOf[String]),
      "GET",
      """ AWS EC2 EBS 備份
 不適當的寫法,予以紀錄,只是有這用法,其應用在正規表示去除字串
GET     /backupEBS&describe=$describe<(\w+)>&snapshotTag=$snapshotTag<(\w+)>          controllers.Application.backupInstanceEBS(describe:String,snapshotTag:String)
 Query string method, we can get the webPage  <website site>/backupEBS?regionEndPoint:String=ec2.ap-northeast-1.amazonaws.com&describe=demo&snapshotTag=demo""",
      this.prefix + """backupEBS"""
    )
  )

  // @LINE:34
  private[this] lazy val controllers_Test_test5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tdd&id="), DynamicPart("id", """(\w+)""",false), StaticPart("&value="), DynamicPart("value", """(\w+)""",false)))
  )
  private[this] lazy val controllers_Test_test5_invoker = createInvoker(
    Test_1.test(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Test",
      "test",
      Seq(classOf[String], classOf[String]),
      "GET",
      """ 動態切割Query String, Dyamic part
 https://www.playframework.com/documentation/2.4.x/ScalaRouting""",
      this.prefix + """tdd&id=$id<(\w+)>&value=$value<(\w+)>"""
    )
  )

  // @LINE:38
  private[this] lazy val controllers_Test_test6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("clients")))
  )
  private[this] lazy val controllers_Test_test6_invoker = createInvoker(
    Test_1.test(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Test",
      "test",
      Seq(classOf[String], classOf[String]),
      "GET",
      """ Parameters with default values
GET     /clients        controllers.Test.test2(page:String)""",
      this.prefix + """clients"""
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
        controllers_Query_getWPqueryEC2Info2_invoker.call(Query_2.getWPqueryEC2Info())
      }
  
    // @LINE:19
    case controllers_Query_postReturnEC2Info3_route(params) =>
      call { 
        controllers_Query_postReturnEC2Info3_invoker.call(Query_2.postReturnEC2Info())
      }
  
    // @LINE:30
    case controllers_Application_backupInstanceEBS4_route(params) =>
      call(params.fromQuery[String]("regionEndpoint", Some("ec2.ap-northeast-1.amazonaws.com" )), params.fromQuery[String]("describe", None), params.fromQuery[String]("snapshotTag", None)) { (regionEndpoint, describe, snapshotTag) =>
        controllers_Application_backupInstanceEBS4_invoker.call(Application_0.backupInstanceEBS(regionEndpoint, describe, snapshotTag))
      }
  
    // @LINE:34
    case controllers_Test_test5_route(params) =>
      call(params.fromPath[String]("id", None), params.fromPath[String]("value", None)) { (id, value) =>
        controllers_Test_test5_invoker.call(Test_1.test(id, value))
      }
  
    // @LINE:38
    case controllers_Test_test6_route(params) =>
      call(params.fromQuery[String]("id", Some("cdda" )), params.fromQuery[String]("value", None)) { (id, value) =>
        controllers_Test_test6_invoker.call(Test_1.test(id, value))
      }
  }
}