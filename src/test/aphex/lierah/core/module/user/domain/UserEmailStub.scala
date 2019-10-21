package aphex.lierah.core.module.user.domain

import aphex.lierah.core.module.shared.domain.FakerStub
import aphex.lierah.core.module.user.domain.value_object.UserEmail

object UserEmailStub {
  def apply(value: String): UserEmail = UserEmail(value)

  def random: UserEmail = UserEmail(FakerStub.fake.internet().emailAddress())
}
