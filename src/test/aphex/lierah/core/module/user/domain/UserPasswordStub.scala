package aphex.lierah.core.module.user.domain

import aphex.lierah.core.module.shared.domain.FakerStub
import aphex.lierah.core.module.user.domain.value_object.{UserPassword, UserPasswordHash}

object UserPasswordStub {
  def apply(value: String): UserPasswordHash = UserPassword(value)

  def random: UserPasswordHash = UserPassword(
    FakerStub.fake.internet().password(8, 30, true, true, true)
  )
}
