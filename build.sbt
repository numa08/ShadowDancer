seq(conscriptSettings :_*)

organization := "net.numa08"

name := "sdancer"

version := "0.6.0"

resolvers += "Local" at "file://" + Path.userHome.absolutePath + "/.m2/repository"

libraryDependencies ++= Seq(
  "com.twitter" % "util-eval_2.10" % "6.10.0",
  "org.scalatest" % "scalatest_2.10" % "2.0" % "test",
  "org.gitlab" % "java-gitlab-api" % "1.1.3"
)

libraryDependencies ++= Seq(
  "com.typesafe" %% "scalalogging-slf4j" % "1.1.0",
  "org.slf4j" % "slf4j-api" % "1.7.1",
  "ch.qos.logback" % "logback-classic" % "1.0.7"
)