name := """ships"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  evolutions,
  cache,
  javaWs,
  "org.webjars" % "bootstrap" % "3.3.5",
  "org.webjars" % "jquery" % "1.11.1",
  "org.webjars" % "knockout" % "3.2.0"
)
