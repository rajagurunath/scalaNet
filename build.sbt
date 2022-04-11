ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "customNN"
  )

libraryDependencies += "be.botkop" %% "numsca" % "0.1.7"

homepage := Some(url("https://github.com/botkop"))
