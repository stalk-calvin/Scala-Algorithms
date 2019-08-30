name := "Scala Algorithms"
organization := "org.calvin"
version := "1.0.0-SNAPSHOT"
scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.scalactic" %% "scalactic" % "3.0.1",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test",
  "com.github.nscala-time" %% "nscala-time" % "2.22.0",
  "org.scala-lang.modules" %% "scala-xml" % "1.2.0"
)

