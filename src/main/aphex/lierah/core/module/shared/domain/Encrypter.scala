package aphex.lierah.core.module.shared.domain

import org.mindrot.jbcrypt.BCrypt

case class Encrypter() {
  def hashPassword(plainPassword: String): String = BCrypt.hashpw(plainPassword, BCrypt.gensalt)

  def check(plainPassword: String, passwordHashed: String): Boolean = BCrypt.checkpw(plainPassword, passwordHashed)
}
