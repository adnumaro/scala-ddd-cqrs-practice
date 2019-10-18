package aphex.lierah.core.module.user.application.register

import aphex.lierah.core.module.user.domain.{User, UserRepository}
import aphex.lierah.core.module.user.domain.value_object._

final class UserRegisterer(repository: UserRepository) {
  def register(
      uuid: UserUuid,
      username: UserUsername,
      email: UserEmail,
      password: UserPassword
  ): Unit = {
    val user = User(uuid, username, email, password)

    repository.save(user)
  }
}
