package aphex.lierah.core.user.domain

import java.util.UUID

object UserId {
  def apply(value: String): UserId = UserId(UUID.fromString(value))
}

case class UserId(value: UUID)
