package aphex.lierah.core.module.user.domain.value_object

import aphex.lierah.core.module.shared.domain.Encrypter

object UserPassword {
  val Pattern = "(?=.*?)[\\p{Alnum}\\p{Punct}]{8,30}"

  def apply(plainPassword: String): UserPasswordHash = plainPassword match {
    case plainPassword if plainPassword.matches(Pattern) =>
      new UserPasswordHash(Encrypter(plainPassword).hash)
    case _ => throw new Exception(s"Password ${plainPassword} is invalid")
  }
}
