package aphex.lierah.core.module.user.domain

import aphex.lierah.core.module.shared.domain.{IntStub, StringStub}
import aphex.lierah.core.module.user.domain.value_object.{UserPassword, UserPasswordHash}

object UserPasswordStub {
  private val minimumChars = 8
  private val maximumChars = 30

  def apply(value: String): UserPasswordHash = UserPassword(value)

  def random: UserPasswordHash = UserPassword(
    StringStub.random(length = IntStub.randomBetween(minimumChars, maximumChars),
                      minLower = 1,
                      minUpper = 1,
                      minNum = 1,
                      minSpecial = 1)
  )
}
