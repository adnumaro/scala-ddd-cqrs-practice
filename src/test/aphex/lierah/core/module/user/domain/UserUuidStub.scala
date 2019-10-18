package aphex.lierah.core.module.user.domain

import java.util.UUID

import aphex.lierah.core.module.shared.domain.UuidStub
import aphex.lierah.core.module.user.domain.value_object.UserUuid

object UserUuidStub {
  def apply(value: String): UserUuid = UserUuidStub(UuidStub(value))

  def apply(value: UUID): UserUuid = UserUuid(value)

  def random: UserUuid = UserUuid(UuidStub.random)
}
