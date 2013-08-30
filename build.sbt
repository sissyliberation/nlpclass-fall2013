import com.typesafe.sbt.SbtStartScript

name := "nlpclass-fall2013"

organization := "com.utcompling"

version := "0002"

scalaVersion := "2.10.2"

resolvers ++= Seq(
  "dhg releases repo" at "http://www.cs.utexas.edu/~dhg/maven-repository/releases",
  "dhg snapshot repo" at "http://www.cs.utexas.edu/~dhg/maven-repository/snapshots"
)

libraryDependencies ++= Seq(
   "dhg" % "scala-util_2.10" % "1.0.0-SNAPSHOT" changing(),
   "edu.stanford.nlp" % "stanford-corenlp" % "3.2.0",
   "com.typesafe" % "scalalogging-log4j_2.10" % "1.0.1",
   "org.apache.logging.log4j" % "log4j-core" % "2.0-beta3",
   "junit" % "junit" % "4.10" % "test",
   "com.novocode" % "junit-interface" % "0.8" % "test->default"
  )

seq(SbtStartScript.startScriptForClassesSettings: _*)

SbtStartScript.stage in Compile := Unit

scalacOptions ++= Seq("-deprecation")

