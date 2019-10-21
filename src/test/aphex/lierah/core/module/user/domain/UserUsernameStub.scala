package aphex.lierah.core.module.user.domain

import aphex.lierah.core.module.shared.domain.FakerStub
import aphex.lierah.core.module.user.domain.value_object.UserUsername

object UserUsernameStub {
  def apply(value: String): UserUsername = UserUsername(value)

  def random: UserUsername = UserUsername(FakerStub.fake.name().username())
}
