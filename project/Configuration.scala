import sbt.{Tests, _}
import sbt.Keys._

object Configuration {
  val settings = Seq(
    organization := "aphex.lierah",
    scalaVersion := "2.12.4",

    // Custom folders path (/src/main/scala and /src/test/scala by default)
    mainClass in Compile := Some("aphex.lierah.core.AphexApi"),
    scalaSource in Compile := baseDirectory.value / "/src/main",
    scalaSource in Test := baseDirectory.value / "/src/test",
    resourceDirectory in Compile := baseDirectory.value / "conf",

    // Compiler options
    scalacOptions ++= Seq(
      "-deprecation", // Warnings deprecation
      "-feature", // Advise features
      "-unchecked", // More warnings. Strict
      "-Xlint", // More warnings when compiling
      "-Xfatal-warnings", // Warnings became errors
      "-Ywarn-dead-code",
      "-Ywarn-unused",
      "-Ywarn-unused-import",
      "-Xcheckinit" // Check against early initialization
    ),
    // Remove it in production because it's expensive
    scalacOptions in run in Compile -= "-Xcheckinit",
    javaOptions += "-Duser.timezone=UTC",

    // Test options
    parallelExecution in Test := false,
    testForkedParallel in Test := false,
    fork in Test := true,
    testOptions in Test ++= Seq(
      // Save test reports
      Tests.Argument(TestFrameworks.ScalaTest, "-u", "target/test-reports"),
      // Show full stack traces and time spent in each test
      Tests.Argument("-oDF")
    )
  )
}
