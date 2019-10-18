package aphex.lierah.core.module.user.domain.value_object

import java.util.UUID

object UserUuid {
  def apply(uuid: String): UserUuid = UserUuid(UUID.fromString(uuid))
}

case class UserUuid(uuid: UUID)
