import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "nanta"
    val appVersion      = "0.0.1"

    val appDependencies = Seq(
      "com.typesafe.akka" % "akka-actor" % "2.0.1",
      "com.h2database" % "h2" % "1.3.166",
      "org.springframework" % "spring-jdbc" % "3.1.1.RELEASE"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
	  organization := "com.lsworks.nanta",
      scalaVersion := "2.9.1"
    )
}
