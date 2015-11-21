package controllers


import play.api._
import play.api.mvc._

import com.amazonaws.auth.AWSCredentials
import com.amazonaws.services.ec2.AmazonEC2Client
import com.amazonaws.services.ec2.model._




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



//  aws instance send a request to admin server, the server will get the instance's volumeId,
//  and make a snapshot for volume, instance need to set snapshot's describe and tag
  def backupInstanceEBS(describe:String,snapshotTag:String)= Action{
    request => {
      val clientIp:String = request.remoteAddress
//      val cred = new AWSCredentials {
//        override def getAWSAccessKeyId: String = ""
//
//        override def getAWSSecretKey: String = ""
//      }

//    使用IAM Role 方式驗證,需把setEndPoint,改成以設定檔方式讀入改變
      val cred = new com.amazonaws.auth.InstanceProfileCredentialsProvider
      val ec2ClientTest = new AmazonEC2Client(cred)
      ec2ClientTest.setEndpoint("ec2.ap-northeast-1.amazonaws.com")

//    取得instance 的 private ip, 並以此ip調閱基本資訊取得 instancec 完整資訊,並從此資訊中取出volumeId
      val describeInstanceFilterList = new DescribeInstancesRequest
      val instanceIpFilter = new com.amazonaws.services.ec2.model.Filter()
      instanceIpFilter.withName("private-ip-address").withValues(clientIp)
      describeInstanceFilterList.withFilters(instanceIpFilter)
      val instanceInfo = ec2ClientTest.describeInstances(describeInstanceFilterList)
      val volumeInfo = instanceInfo.getReservations.get(0).getInstances.get(0).getBlockDeviceMappings
      //    println(volumeInfo.get(1).getEbs.getVolumeId)

//    將volumeId轉存成迭代器,並對裡面的volume已經建立的snapshot存在日期進行診斷
      val volumeInfoIterator = volumeInfo.iterator()
      while(volumeInfoIterator.hasNext){
//      取出volume資訊
        val eachVolume = volumeInfoIterator.next()
        val eachVolumeId=eachVolume.getEbs.getVolumeId

        //  調出指定的volumeID的快照
        val volumeIDFilter = new com.amazonaws.services.ec2.model.Filter()
        volumeIDFilter.withName("volume-id").withValues(eachVolumeId)
        val ddrq = new DescribeSnapshotsRequest().withFilters(volumeIDFilter)
        val thisVolSnapAllshots = ec2ClientTest.describeSnapshots(ddrq).getSnapshots

        //  將調閱出的結果轉成迭代器，偵測紀錄若超過十天，則刪除該筆快照
        val snapShotIterator = thisVolSnapAllshots.iterator()
        while(snapShotIterator.hasNext){
          val nowTimeMillsSeconds = new java.util.Date().getTime

          val eachSnapshot = snapShotIterator.next()
          //  十天 86400000 毫秒
          if(nowTimeMillsSeconds - eachSnapshot.getStartTime.getTime > 10800000 ){
            //          println(eachSnapshot)
            val tempDelete = new DeleteSnapshotRequest().withSnapshotId(eachSnapshot.getSnapshotId)
            ec2ClientTest.deleteSnapshot(tempDelete)
          }
          //      println( nowTimeMillsSeconds - snapShotIterator.next().getStartTime.getTime)
        }
        //  創建新快照,並且為快照設定標籤
        val snapShotRequestInfo = new CreateSnapshotRequest(eachVolumeId,describe)
        val ttd = ec2ClientTest.createSnapshot(snapShotRequestInfo)
        val tagTest = new CreateTagsRequest().withResources(ttd.getSnapshot.getSnapshotId()).withTags(new Tag("Name",snapshotTag))
        ec2ClientTest.createTags(tagTest)
      }

      Ok("success")
    }
  }

}
