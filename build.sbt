

name := "awsEC2AdminServer"

version := "1.0.3"

scalaVersion := "2.11.7"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

libraryDependencies ++= Seq(
  "com.amazonaws" % "aws-java-sdk-ec2" % "1.10.33",
  "com.amazonaws" % "aws-java-sdk-iam" % "1.10.33"
)


// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
