package aphex.lierah.core.module.user.domain

import aphex.lierah.core.module.user.domain.value_object._

object User {
  def apply(uuid: String, username: String, email: String, password: String): User =
    User(UserUuid(uuid), UserUsername(username), UserEmail(email), UserPasswordHash(password))
}

case class User(uuid: UserUuid, username: UserUsername, email: UserEmail, password: UserPasswordHash)
