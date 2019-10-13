package aphex.lierah.core.module.user.application.search

import scala.concurrent.Future

import aphex.lierah.core.module.user.domain.{User, UserRepository}

final class UsersSearcher(repository: UserRepository) {
  def all(): Future[Seq[User]] = repository.all()
}
