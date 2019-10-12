package aphex.lierah.core.module.user.application.search

import aphex.lierah.core.module.user.domain.{User, UserRepository}


final class UsersSearcher(repository: UserRepository) {
  def all(): Seq[User] = repository.all()
}
