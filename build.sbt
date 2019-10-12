/** ********* PROJECT INFO ***************** */
name := "aphex"
version := "0.1"

/** ********* PROJECT SETTINGS ***************** */
Configuration.settings

/** ********* PROD DEPENDENCIES **************** */
libraryDependencies ++= Dependencies.production

/** ********* TEST DEPENDENCIES **************** */
libraryDependencies ++= Dependencies.test

/** ********* COMMANDS ALIASES ***************** */
addCommandAlias("t", "test")
addCommandAlias("to", "testOnly")
addCommandAlias("tq", "testQuick")
addCommandAlias("tsf", "testShowFailed")

addCommandAlias("c", "compile")
addCommandAlias("tc", "test:compile")

addCommandAlias("s", "scalastyle")
addCommandAlias("ts", "test:scalastyle")

// Format all files according to ScalaFmt
addCommandAlias("f", "scalafmt")

// Test if all files are formatted according to ScalaFmt
addCommandAlias("ft", "scalafmtTest")

// All the needed tasks before running the test
addCommandAlias("prep", ";c;tc;s;ts;ft")
