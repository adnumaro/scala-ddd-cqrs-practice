package aphex.lierah.core.module.shared.domain

import org.mindrot.jbcrypt.BCrypt

case class Encrypter(plainPassword: String) {
  val hash: String = BCrypt.hashpw(plainPassword, BCrypt.gensalt)

  def isEqualsTo(passwordHashed: String): Boolean = BCrypt.checkpw(plainPassword, passwordHashed)
}
