package aphex.lierah.core.user.infrastructure.stub

import aphex.lierah.core.shared.infrastructure.stub.{IntStub, StringStub}
import aphex.lierah.core.user.domain.UserName

object UserNameStub {
  private val minimumChars = 1
  private val maximumChars = 20

  def apply(value: String): UserName = UserName(value)

  def random: UserName = UserName(
    StringStub.random(numChars = IntStub.randomBetween(minimumChars, maximumChars))
  )
}
