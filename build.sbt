import PlayKeys.devSettings

name := """ships"""

version := "1.0"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  evolutions,
  cache,
  javaWs,
  "org.webjars" % "bootstrap" % "3.3.6",
  "org.webjars" % "jquery" % "1.12.0",
  "org.webjars" % "knockout" % "3.2.0",
  "org.postgresql" % "postgresql" % "9.4.1208"
)

devSettings += ("db.default.driver", "org.h2.Driver")
devSettings += ("db.default.url", "jdbc:h2:file:~/ships")
