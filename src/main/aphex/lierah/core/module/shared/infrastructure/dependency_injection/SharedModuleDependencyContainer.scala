package aphex.lierah.core.module.shared.infrastructure.dependency_injection

import scala.concurrent.ExecutionContext

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer

import aphex.lierah.core.module.shared.infrastructure.config.DbConfig
import aphex.lierah.core.module.shared.infrastructure.persistence.doobie.DoobieDbConnection

final class SharedModuleDependencyContainer(actorSystemName: String, dbConfig: DbConfig) {
  implicit val actorSystem: ActorSystem  = ActorSystem(actorSystemName)
  val materializer: ActorMaterializer    = ActorMaterializer()
  val executionContext: ExecutionContext = actorSystem.dispatcher

  val doobieDbConnection = new DoobieDbConnection(dbConfig)
}
