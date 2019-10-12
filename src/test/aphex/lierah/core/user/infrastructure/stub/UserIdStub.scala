package aphex.lierah.core.user.infrastructure.stub

import java.util.UUID

import aphex.lierah.core.shared.infrastructure.stub.UuidStub
import aphex.lierah.core.user.domain.UserId

object UserIdStub {
  def apply(value: String): UserId = UserIdStub(UuidStub(value))

  def apply(value: UUID): UserId = UserId(value)

  def random: UserId = UserId(UuidStub.random)
}
