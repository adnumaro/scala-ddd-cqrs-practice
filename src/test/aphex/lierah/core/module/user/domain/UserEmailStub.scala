package aphex.lierah.core.module.user.domain

import aphex.lierah.core.module.shared.domain.{IntStub, StringStub}
import aphex.lierah.core.module.user.domain.value_object.UserEmail

object UserEmailStub {
  private val minimumChars = 2
  private val maximumChars = 10

  def apply(value: String): UserEmail = UserEmail(value)

  def random: UserEmail = UserEmail(
    StringStub.random(numChars = IntStub.randomBetween(minimumChars, maximumChars)) + "@" +
      StringStub.random(numChars = IntStub.randomBetween(minimumChars, maximumChars)) + ".com"
  )
}
