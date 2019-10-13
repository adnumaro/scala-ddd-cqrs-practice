import sbt._

object Dependencies {

  object Versions {
    val akka     = "2.5.25"
    val akkaHttp = "10.1.10"
  }

  val production = Seq(
    "com.github.nscala-time" %% "nscala-time"          % "2.18.0",
    "com.lihaoyi"            %% "pprint"               % "0.5.3",
    "com.typesafe.akka"      %% "akka-http"            % Versions.akkaHttp,
    "com.typesafe.akka"      %% "akka-actor"           % Versions.akka,
    "com.typesafe.akka"      %% "akka-stream"          % Versions.akka,
    "com.typesafe.akka"      %% "akka-http-spray-json" % Versions.akkaHttp,
    "org.tpolecat"           %% "doobie-core"          % "0.5.0",
    "org.postgresql"         % "postgresql"            % "42.2.5",
    "com.github.scopt"       %% "scopt"                % "3.7.0"
  )
  val test = Seq(
    "org.scalatest"     %% "scalatest"         % "3.0.8"           % Test,
    "org.scalamock"     %% "scalamock"         % "4.4.0"           % Test,
    "com.typesafe.akka" %% "akka-testkit"      % Versions.akka     % Test,
    "com.typesafe.akka" %% "akka-http-testkit" % Versions.akkaHttp % Test
  )
}
