package aphex.lierah.core.module.user

import aphex.lierah.core.module.IntegrationTestCase
import aphex.lierah.core.module.user.domain.UserRepository
import aphex.lierah.core.module.user.infrastructure.dependency_injection.UserModuleDependencyContainer

protected[user] trait UserIntegrationTestCase extends IntegrationTestCase {
  private val container = new UserModuleDependencyContainer(doobieDbConnection)

  protected val repository: UserRepository = container.repository
}
