package aphex.lierah.core.module.user.infrastructure.repository

import scala.concurrent.Future

import doobie.implicits._

import aphex.lierah.core.module.shared.infrastructure.persistence.doobie.DoobieDbConnection
import aphex.lierah.core.module.shared.infrastructure.persistence.doobie.TypesConversions._
import aphex.lierah.core.module.user.domain.{User, UserRepository}

final class DoobieUserRepository(db: DoobieDbConnection) extends UserRepository {
  override def all(): Future[Seq[User]] = {
    db.read(sql"SELECT user_id, name FROM users".query[User].to[Seq])
  }
}
