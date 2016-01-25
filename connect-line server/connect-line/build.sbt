name := """connect-line"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "org.projectlombok" % "lombok" % "1.16.6",
  "junit" % "junit" % "4.11" % "test",
  "org.hamcrest" % "hamcrest-all" % "1.3",
  "org.scalatest" % "scalatest_2.10" % "2.0" % "test",
  specs2 % Test
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
