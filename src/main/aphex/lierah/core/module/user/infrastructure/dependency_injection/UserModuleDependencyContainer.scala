package aphex.lierah.core.module.user.infrastructure.dependency_injection

import scala.concurrent.ExecutionContext

import aphex.lierah.core.module.shared.infrastructure.persistence.doobie.DoobieDbConnection
import aphex.lierah.core.module.user.application.register.UserRegisterer
import aphex.lierah.core.module.user.application.search.UsersSearcher
import aphex.lierah.core.module.user.domain.UserRepository
import aphex.lierah.core.module.user.infrastructure.repository.DoobieUserRepository

final class UserModuleDependencyContainer(doobieDbConnection: DoobieDbConnection)(
    implicit executionContext: ExecutionContext) {
  val repository: UserRepository = new DoobieUserRepository(doobieDbConnection)

  val usersSearcher: UsersSearcher   = new UsersSearcher(repository)
  val userRegisterer: UserRegisterer = new UserRegisterer(repository)
}
