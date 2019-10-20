package aphex.lierah.core.module.user.domain

import aphex.lierah.core.module.shared.domain.{IntStub, StringStub}
import aphex.lierah.core.module.user.domain.value_object.UserUsername

object UserUsernameStub {
  private val minimumChars = 3
  private val maximumChars = 30

  def apply(value: String): UserUsername = UserUsername(value)

  def random: UserUsername = UserUsername(
    StringStub.randomAlphaNumeric(length = IntStub.randomBetween(minimumChars, maximumChars))
  )
}
