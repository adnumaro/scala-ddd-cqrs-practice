package aphex.lierah.core.module

import scala.concurrent.ExecutionContext

import com.typesafe.config.ConfigFactory

import aphex.lierah.core.module.shared.infrastructure.config.DbConfig
import aphex.lierah.core.module.shared.infrastructure.dependency_injection.SharedModuleDependencyContainer
import aphex.lierah.core.module.shared.infrastructure.persistence.doobie.DoobieDbConnection

protected[core] trait IntegrationTestCase extends UnitTestCase {
  private val appConfig       = ConfigFactory.load("application")
  private val dbConfig        = DbConfig(appConfig.getConfig("database"))
  private val actorSystemName = "aphex-api-integration-test"

  protected val sharedDependencies = new SharedModuleDependencyContainer(actorSystemName, dbConfig)

  implicit protected val executionContext: ExecutionContext = sharedDependencies.executionContext

  protected val doobieDbConnection: DoobieDbConnection = sharedDependencies.doobieDbConnection
}
