name := "DataFrame"

version := "0.1"

scalaVersion := "2.12.8"

import AssemblyPlugin._

assemblySettings

// https://mvnrepository.com/artifact/org.apache.spark/spark-sql
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.4.0"

// https://mvnrepository.com/artifact/org.apache.spark/spark-core
libraryDependencies += "org.apache.spark" %% "spark-core" % "2.4.0"

// https://mvnrepository.com/artifact/log4j/log4j
libraryDependencies += "log4j" % "log4j" % "1.2.17"


resolvers += Resolver.url("bintray-sbt-plugins", url("http://dl.bintray.com/sbt/sbt-plugin-releases"))(Resolver.ivyStylePatterns)

resolvers += Resolver.bintrayIvyRepo("com.eed3si9n", "sbt-plugins")

lazy val commonSettings = Seq(
  organization := "com.bridgelabz",
  version := "0.1.0-SNAPSHOT"
)

// set the main class for packaging the main jar
mainClass in (Compile, packageBin) := Some("com.piyush.DataFrameJAR")

// set the main class for the main 'sbt run' task
mainClass in (Compile, run) := Some("com.piyush.DataFrameJAR")


resolvers in Global ++= Seq(
  "Sbt plugins" at "https://dl.bintray.com/sbt/sbt-plugin-releases",
  "Maven Central Server" at "http://repo1.maven.org/maven2",
  "TypeSafe Repository Releases" at "http://repo.typesafe.com/typesafe/releases/",
  "TypeSafe Repository Snapshots" at "http://repo.typesafe.com/typesafe/snapshots/"
)

lazy val root = (project in file(".")).
  settings(
    name := "Week10V2.0",
    version := "0.1",
    scalaVersion := "2.12.8",
    Compile / mainClass := Some("com.piyush.DataFrameJAR")
  )
  .settings(commonSettings: _*)
  .enablePlugins(AssemblyPlugin)

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}