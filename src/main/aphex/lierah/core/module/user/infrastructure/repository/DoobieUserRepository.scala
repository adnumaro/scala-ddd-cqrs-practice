package aphex.lierah.core.module.user.infrastructure.repository

import scala.concurrent.{ExecutionContext, Future}

import doobie.implicits._

import aphex.lierah.core.module.shared.infrastructure.persistence.doobie.DoobieDbConnection
import aphex.lierah.core.module.shared.infrastructure.persistence.doobie.TypesConversions._
import aphex.lierah.core.module.user.domain.{User, UserRepository}

final class DoobieUserRepository(db: DoobieDbConnection)(implicit executionContext: ExecutionContext)
    extends UserRepository {
  override def all(): Future[Seq[User]] = {
    sql"""
      SELECT uuid, username, email, password
      FROM users
      """
      .query[User]
      .to[Seq]
      .transact(db.transactor)
      .unsafeToFuture()
  }

  override def save(user: User): Future[Unit] =
    sql"""
       INSERT INTO users(uuid, username, email, password)
       VALUES (${user.uuid}, ${user.username}, ${user.email}, ${user.password})
      """.update.run
      .transact(db.transactor)
      .unsafeToFuture()
      .map(_ => ())
}
