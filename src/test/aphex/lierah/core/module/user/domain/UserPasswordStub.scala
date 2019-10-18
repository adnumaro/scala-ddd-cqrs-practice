package aphex.lierah.core.module.user.domain

import aphex.lierah.core.module.shared.domain.{IntStub, StringStub}
import aphex.lierah.core.module.user.domain.value_object.UserPassword

object UserPasswordStub {
  private val minimumChars = 8
  private val maximumChars = 30

  def apply(value: String): UserPassword = UserPassword(value)

  def random: UserPassword = UserPassword(
    StringStub.random(numChars = IntStub.randomBetween(minimumChars, maximumChars))
  )
}
