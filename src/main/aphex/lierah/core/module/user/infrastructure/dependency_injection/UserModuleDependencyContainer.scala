package aphex.lierah.core.module.user.infrastructure.dependency_injection

import aphex.lierah.core.module.shared.infrastructure.persistence.doobie.DoobieDbConnection
import aphex.lierah.core.module.user.application.search.UsersSearcher
import aphex.lierah.core.module.user.domain.UserRepository
import aphex.lierah.core.module.user.infrastructure.repository.DoobieUserRepository

final class UserModuleDependencyContainer(doobieDbConnection: DoobieDbConnection) {
  val repository: UserRepository = new DoobieUserRepository(doobieDbConnection)

  val usersSearcher = new UsersSearcher(repository)
}
