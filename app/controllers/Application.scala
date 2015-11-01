package controllers


import play.api._
import play.api.mvc._





class Application extends Controller {


  //  def index = Action {
  //    Ok(views.html.index("Your new application is ready."))
  //  }
  //  取得client ip, 再依照aws cli 去抓出ip的擁有instance

  //  調用ip資訊的instance
  //  aws ec2 describe-instances --filters "Name=private-ip-address,Values=<private ip>"

  def getIp = Action{
    request => {
      Ok(request.remoteAddress)
    }
  }

  def restartInstance = Action{
    request => {
      import scala.util.matching.Regex

      val clientIp:String = request.remoteAddress
      //
      println(clientIp)
      //    調用Linux外部程序
      //    http://alvinalexander.com/scala/scala-execute-exec-external-system-commands-in-scala
      import scala.sys.process._
      //  scala使用字串printf功能
      //  http://docs.scala-lang.org/overviews/core/string-interpolation.html
      //      val awsDescribeEC2Info = s"""aws ec2 describe-instances --filters Name=ip-address,Values=$clientIp""" #| "grep InstanceId"
      //      val instanceInfo = awsDescribeEC2Info !!
      val instanceInfo:String  = s"""aws ec2 describe-instances --filters Name=private-ip-address,Values=$clientIp""" #| "grep InstanceId" !!

      //  scala 正規表示法
      //  http://www.tutorialspoint.com/scala/scala_regular_expressions.htm
      //      val instanceInfo = """"InstanceId": "i-f7e74852","""
      //      import scala.util.matching.Regex
      val pattern = new Regex("\\w+-\\w+")
      val instanceID = pattern.findFirstIn(instanceInfo).getOrElse("The Instance has not exist")
      println(instanceID)
      //    Close the instance
      s"aws ec2 stop-instances --instance-ids $instanceID" !
      import scala.concurrent._
      import ExecutionContext.Implicits.global
      Future{
        Thread.sleep(120000)
        val startInstance =s"aws ec2 start-instances --instance-ids $instanceID" !!

        Thread.sleep(120000)


        val getInstanceIp = s"aws ec2 describe-instances --instance-ids $instanceID" #| "grep PublicIpAddress" #> new java.io.File("IpAddress.txt") !!
        val mailToAdmin1 =  s"mail -s test b97607065@gmail.com" #< new java.io.File("IpAddress.txt") !!
        val mailToMindy = s"mail -s test litchi.z.92001@gmail.com" #< new java.io.File("IpAddress.txt") !!
      }

      Ok(s"$instanceID has already restart")
    }
  }

}
