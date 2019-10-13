package aphex.lierah.core.module.shared.infrastructure.dependency_injection

import aphex.lierah.core.module.shared.infrastructure.config.DbConfig
import aphex.lierah.core.module.shared.infrastructure.persistence.doobie.DoobieDbConnection

final class SharedModuleDependencyContainer(dbConfig: DbConfig) {
  val doobieDbConnection = new DoobieDbConnection(dbConfig)
}
