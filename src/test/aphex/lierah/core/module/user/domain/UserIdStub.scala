package aphex.lierah.core.module.user.domain

import java.util.UUID

import aphex.lierah.core.module.shared.domain.UuidStub

object UserIdStub {
  def apply(value: String): UserId = UserIdStub(UuidStub(value))

  def apply(value: UUID): UserId = UserId(value)

  def random: UserId = UserId(UuidStub.random)
}
