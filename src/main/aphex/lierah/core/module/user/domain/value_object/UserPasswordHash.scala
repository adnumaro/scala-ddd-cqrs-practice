package aphex.lierah.core.module.user.domain.value_object

import aphex.lierah.core.module.shared.domain.Encrypter

case class UserPasswordHash(passwordHashed: String) {
  def check(plainPassword: String): Boolean = Encrypter(plainPassword).isEqualsTo(passwordHashed)
}

object UserPasswordHash {
  def apply(passwordHashed: String): UserPasswordHash = new UserPasswordHash(passwordHashed)
}
