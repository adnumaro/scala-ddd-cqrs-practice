import sbt._

object Dependencies {

  val production = Seq(
    "com.github.nscala-time" %% "nscala-time"          % "2.22.0",
    "com.lihaoyi"            %% "pprint"               % "0.5.5",
    "com.typesafe.akka"      %% "akka-http"            % Versions.akkaHttp,
    "com.typesafe.akka"      %% "akka-actor"           % Versions.akka,
    "com.typesafe.akka"      %% "akka-stream"          % Versions.akka,
    "com.typesafe.akka"      %% "akka-http-spray-json" % Versions.akkaHttp,
    "org.tpolecat"           %% "doobie-core"          % "0.8.4",
    "org.postgresql"         % "postgresql"            % "42.2.8",
    "com.github.scopt"       %% "scopt"                % "4.0.0-RC2",
    "org.mindrot"            % "jbcrypt"               % "0.4"
  )
  val test = Seq(
    "org.scalatest"        %% "scalatest"         % "3.0.8"           % Test,
    "org.scalamock"        %% "scalamock"         % "4.4.0"           % Test,
    "com.typesafe.akka"    %% "akka-testkit"      % Versions.akka     % Test,
    "com.typesafe.akka"    %% "akka-http-testkit" % Versions.akkaHttp % Test,
    "com.github.javafaker" % "javafaker"          % "1.0.1"           % Test
  )

  object Versions {
    val akka     = "2.5.26"
    val akkaHttp = "10.1.10"
  }
}
