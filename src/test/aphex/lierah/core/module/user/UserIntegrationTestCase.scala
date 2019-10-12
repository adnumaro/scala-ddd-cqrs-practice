package aphex.lierah.core.module.user

import aphex.lierah.core.module.IntegrationTestCase
import aphex.lierah.core.module.user.infrastructure.dependency_injection.UserModuleDependencyContainer
import aphex.lierah.core.module.user.infrastructure.repository.InMemoryUserRepository

protected[user] trait UserIntegrationTestCase extends IntegrationTestCase {
  private val container = new UserModuleDependencyContainer

  protected val repository: InMemoryUserRepository = container.repository
}
