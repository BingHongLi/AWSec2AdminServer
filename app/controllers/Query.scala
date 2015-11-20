package controllers

/**
 * Created by cirrusdi on 11/1/15.
 */


import com.amazonaws.services.ec2._
import com.amazonaws.auth.AWSCredentials
import com.amazonaws.services.ec2.model.DescribeInstancesRequest

import play.api.mvc.{BodyParsers, Action, Controller}
import play.api.data.Forms._



class Query extends Controller {

  def getWPqueryEC2Info() = Action{
    //  此函數用來回傳queryEC2Info網頁，使用者尚未輸入表單時的頁面呈現
    Ok(views.html.queryEC2Info(play.twirl.api.Html("test")))
  }

  // 建立表單，所需使用的樣例類，並使用play套件映射，告知是什麼性質的表單
  // 用在queryEC2Info的postReturnEC2Info方法
  case class User(keyName:String,systemPassword:String)
  val userForm = play.api.data.Form(
    mapping(
      "keyName"->text,
      "systemPassword"->text
    )(User.apply)(User.unapply)
  )


  def postReturnEC2Info() = Action{
    // 此函數，用來回傳queryEC2Info網頁，使用者輸入表單後的頁面呈現
    //    Scala symbol
    //    http://blog.csdn.net/bobozhengsir/article/details/13023023

    // 取得request的內容，並使用userForm剖析及取值
    implicit request => val test = userForm.bindFromRequest().get
      // http://stackoverflow.com/questions/7315327/how-to-check-ec2instance-is-running-or-stop-in-aws-using-java
      //  i-f7e74852

      //    DescribeInstancesRequest物件用來放入描述查詢list
      val descrInstanceRequest = new DescribeInstancesRequest()
      //    val javaList = new util.ArrayList[String](5)
      //    javaList.add("i-f7e74852")
      //    println(javaList.get(0))
      //    descrInstanceRequest.setInstanceIds(javaList)

      //    Introduce HowToUse Filter
      //    http://docs.aws.amazon.com/storagegateway/latest/userguide/FindingSnapshotsUsingJava.html

      //    創建aws filter，然後放入descrInstanceRequest物件的值內
      import com.amazonaws.services.ec2.model.Filter
      val ec2Filter = new Filter()
      //    ec2Filter.withName("instance-id").withValues("")
      ec2Filter.withName("key-name").withValues(test.keyName)
      descrInstanceRequest.withFilters(ec2Filter)

      //    創建一個Role的credential
      val cred =new com.amazonaws.auth.InstanceProfileCredentialsProvider



      //    descrInstanceRequest.setFilters()
      //    創建Ec2 client，用來使用EC2指令
      val ec2ClientTest = new AmazonEC2Client(cred)
      //    告知是要用在哪一個Region
      ec2ClientTest.setEndpoint("ec2.ap-northeast-1.amazonaws.com")

      //    生成查詢結果
      val describeInsResult = ec2ClientTest.describeInstances(descrInstanceRequest)

      //    取得Reservations內的Instance清單，若公司有買保留Instance，則這邊需要修改
      val reservationsResult = describeInsResult.getReservations()

      //    println(reservationsResult.get(0).getInstances.get(0).getInstanceId())        // instance-id
      //    println(reservationsResult.get(0).getInstances.get(0).getPublicIpAddress())   // ip
      //    println(reservationsResult.get(0).getInstances.get(0).getTags().get(0).getValue) // Manual-NAT-HA-AZ3-Instance
      //    println(reservationsResult.get(0).getInstances.get(0).getState().getName())
      //    println(reservationsResult.get(0).getInstances.get(0).getPrivateIpAddress())
      println(reservationsResult.size())

      var tableContent = ""

      //    生成table內容
      for(i <- 0 to reservationsResult.size()-1){
        tableContent = tableContent +"<tr>"
        val tempInstance = reservationsResult.get(i).getInstances.get(0)
        //      print(tempInstance.getInstanceId()+"\t")
        tableContent = tableContent + "<td>" +tempInstance.getInstanceId()+"</td>"
        //
        //      print(tempInstance.getTags().get(0).getValue()+"\t ")
        tableContent = tableContent + "<td>" +tempInstance.getTags().get(0).getValue()+"</td>"
        //      print(tempInstance.getState().getName()+"\t")
        tableContent = tableContent + "<td>" +tempInstance.getState().getName()+"</td>"
        //      print(tempInstance.getPublicIpAddress()+"\t")
        tableContent = tableContent + "<td>" +tempInstance.getPublicIpAddress()+"</td>"
        //  print(tempInstance.getPrivateIpAddress())
        tableContent = tableContent + "<td>" +tempInstance.getPrivateIpAddress()+"</td></tr>"
        //      println()
      }





      //    println(ec2ClientTest.describeInstances())
      //    println(" ddd")
      //    println(ec2ClientTest.describeInstances()
      Ok(views.html.queryEC2Info(play.twirl.api.Html(tableContent)))
  }





  def test() = Action{
    //    Scala symbol
    //    http://blog.csdn.net/bobozhengsir/article/details/13023023

    implicit request => val test = userForm.bindFromRequest().get


      val cred = new AWSCredentials {
        override def getAWSAccessKeyId: String = ""

        override def getAWSSecretKey: String = ""
      }
      // http://stackoverflow.com/questions/7315327/how-to-check-ec2instance-is-running-or-stop-in-aws-using-java
      //  i-f7e74852
      val descrInstanceRequest = new DescribeInstancesRequest()
      //    val javaList = new util.ArrayList[String](5)
      //    javaList.add("i-f7e74852")
      //    println(javaList.get(0))
      //    descrInstanceRequest.setInstanceIds(javaList)

      //    Introduce HowToUse Filter
      //    http://docs.aws.amazon.com/storagegateway/latest/userguide/FindingSnapshotsUsingJava.html
      import com.amazonaws.services.ec2.model.Filter
      val ec2Filter = new Filter()
      //    ec2Filter.withName("instance-id").withValues("")
      ec2Filter.withName("key-name").withValues(test.keyName)
      descrInstanceRequest.withFilters(ec2Filter)



      //    descrInstanceRequest.setFilters()
      val ec2ClientTest = new AmazonEC2Client(cred)
      ec2ClientTest.setEndpoint("ec2.ap-northeast-1.amazonaws.com")

      val describeInsResult = ec2ClientTest.describeInstances(descrInstanceRequest)

      val reservationsResult = describeInsResult.getReservations()

      //    println(reservationsResult.get(0).getInstances.get(0).getInstanceId())        // instance-id
      //    println(reservationsResult.get(0).getInstances.get(0).getPublicIpAddress())   // ip
      //    println(reservationsResult.get(0).getInstances.get(0).getTags().get(0).getValue) // Manual-NAT-HA-AZ3-Instance
      //    println(reservationsResult.get(0).getInstances.get(0).getState().getName())
      //    println(reservationsResult.get(0).getInstances.get(0).getPrivateIpAddress())
      println(reservationsResult.size())

      var tableContent = ""

      for(i <- 0 to reservationsResult.size()-1){
        tableContent = tableContent +"<tr>"
        val tempInstance = reservationsResult.get(i).getInstances.get(0)
        //      print(tempInstance.getInstanceId()+"\t")
        tableContent = tableContent + "<td>" +tempInstance.getInstanceId()+"</td>"
        //
        //      print(tempInstance.getTags().get(0).getValue()+"\t ")
        tableContent = tableContent + "<td>" +tempInstance.getTags().get(0).getValue()+"</td>"
        //      print(tempInstance.getState().getName()+"\t")
        tableContent = tableContent + "<td>" +tempInstance.getState().getName()+"</td>"
        //      print(tempInstance.getPublicIpAddress()+"\t")
        tableContent = tableContent + "<td>" +tempInstance.getPublicIpAddress()+"</td>"
        //  print(tempInstance.getPrivateIpAddress())
        tableContent = tableContent + "<td>" +tempInstance.getPrivateIpAddress()+"</td></tr>"
        //      println()
      }





      //    println(ec2ClientTest.describeInstances())
      //    println(" ddd")
      //    println(ec2ClientTest.describeInstances())

      Ok(views.html.queryEC2Info(play.twirl.api.Html(tableContent)))
  }

  def test2() = Action(BodyParsers.parse.json){
    request =>{


      val emailForm = play.api.data.Form(
        single("emailAddress" -> email)
      )

      import play.api.mvc._
      import play.api.libs.json._
      import play.api.libs.functional.syntax._
      println(request.body.as[JsObject].\("emailAddress"))
      //      val emailAddress = emailForm.bindFromRequest().data.get("emailAddress")
      //      println(emailAddress)

      Ok("dd")




    }
  }

}