package aphex.lierah.core.module

import com.typesafe.config.ConfigFactory

import aphex.lierah.core.module.shared.infrastructure.config.DbConfig
import aphex.lierah.core.module.shared.infrastructure.dependency_injection.SharedModuleDependencyContainer
import aphex.lierah.core.module.shared.infrastructure.persistence.doobie.DoobieDbConnection

protected[core] trait IntegrationTestCase extends UnitTestCase {
  private val appConfig = ConfigFactory.load("application")
  private val dbConfig  = DbConfig(appConfig.getConfig("database"))

  private val sharedDependencies = new SharedModuleDependencyContainer(dbConfig)

  protected val doobieDbConnection: DoobieDbConnection = sharedDependencies.doobieDbConnection
}
