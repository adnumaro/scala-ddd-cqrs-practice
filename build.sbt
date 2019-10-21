name := "aphex"
version := "0.1"

Configuration.settings

libraryDependencies ++= Dependencies.production
libraryDependencies ++= Dependencies.test

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
addCommandAlias("tf", "test:scalafmt")

// All the needed tasks before running the test
addCommandAlias("prep", ";clean;c;tc;s;ts;f;tf")

TaskKey[Unit]("createDbTables") := (runMain in Compile)
  .toTask(" aphex.lierah.core.entry_point.cli.DbTablesCreator")
  .value
