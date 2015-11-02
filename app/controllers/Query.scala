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

    Ok(views.html.queryEC2Info(play.twirl.api.Html("test")))
  }


  case class User(keyName:String,systemPassword:String)

  val userForm = play.api.data.Form(
    mapping(
      "keyName"->text,
      "systemPassword"->text
    )(User.apply)(User.unapply)
  )

  def postReturnEC2Info() = Action{
    //    Scala symbol
    //    http://blog.csdn.net/bobozhengsir/article/details/13023023

    implicit request => val test = userForm.bindFromRequest().get



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

      val cred =new com.amazonaws.auth.InstanceProfileCredentialsProvider



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
