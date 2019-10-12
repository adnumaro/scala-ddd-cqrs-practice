package aphex.lierah.core.module.user.infrastructure.dependency_injection

import aphex.lierah.core.module.user.application.search.UsersSearcher
import aphex.lierah.core.module.user.infrastructure.repository.InMemoryUserRepository

final class UserModuleDependencyContainer {
  val repository = new InMemoryUserRepository

  val usersSearcher = new UsersSearcher(repository)
}
