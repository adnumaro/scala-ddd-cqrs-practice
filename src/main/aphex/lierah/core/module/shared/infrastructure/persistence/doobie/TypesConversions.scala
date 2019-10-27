package aphex.lierah.core.module.shared.infrastructure.persistence.doobie

import java.util.UUID

import doobie.util.{Get, Put}

object TypesConversions {
  implicit val uuidGet: Get[UUID] = Get[String].map(UUID.fromString)
  implicit val uuidPut: Put[UUID] = Put[String].contramap(_.toString)
}
