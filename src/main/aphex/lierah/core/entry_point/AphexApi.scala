package aphex.lierah.core.entry_point

import scala.concurrent.ExecutionContextExecutor
import scala.io.StdIn

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.typesafe.config.ConfigFactory

import aphex.lierah.core.module.shared.infrastructure.config.DbConfig
import aphex.lierah.core.module.shared.infrastructure.dependency_injection.SharedModuleDependencyContainer
import aphex.lierah.core.module.user.infrastructure.dependency_injection.UserModuleDependencyContainer

object AphexApi {
  def main(args: Array[String]): Unit = {
    val appConfig    = ConfigFactory.load("application")
    val serverConfig = ConfigFactory.load("http-server")

    val actorSystemName = appConfig.getString("main-actor-system.name")
    val host            = serverConfig.getString("http-server.host")
    val port            = serverConfig.getInt("http-server.port")

    val dbConfig = DbConfig(appConfig.getConfig("database"))

    implicit val system: ActorSystem                        = ActorSystem(actorSystemName)
    implicit val materializer: ActorMaterializer            = ActorMaterializer()
    implicit val executionContext: ExecutionContextExecutor = system.dispatcher

    val sharedDependencies = new SharedModuleDependencyContainer(dbConfig)

    val container = new EntryPointDependencyContainer(
      new UserModuleDependencyContainer(sharedDependencies.doobieDbConnection)
    )

    val routes = new Routes(container)

    val bindingFuture = Http().bindAndHandle(routes.all, host, port)

    bindingFuture.failed.foreach { t =>
      println(s"Failed to bind to http://$host:$port/:") // scalastyle:off println
      pprint.log(t)
    }

    // let it run until user presses return
    println(s"Server online at http://$host:$port/\nPress RETURN to stop...") // scalastyle:off println
    StdIn.readLine()

    bindingFuture
      .flatMap(_.unbind())
      .onComplete(_ => system.terminate())
  }
}
