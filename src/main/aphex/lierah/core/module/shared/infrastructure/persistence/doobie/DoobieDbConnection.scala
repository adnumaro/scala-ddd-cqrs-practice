package aphex.lierah.core.module.shared.infrastructure.persistence.doobie

import cats.effect.IO
import doobie.Transactor
import doobie.syntax.ConnectionIOOps
import doobie.util.transactor.Transactor.Aux
import scala.concurrent.Future

import aphex.lierah.core.module.shared.infrastructure.config.DbConfig

final class DoobieDbConnection(dbConfig: DbConfig) {
  val transactor: Aux[IO, Unit] = Transactor.fromDriverManager[IO](
    dbConfig.driver,
    dbConfig.host,
    dbConfig.user,
    dbConfig.password
  )

  def read[T](query: ConnectionIOOps[T]): Future[T] = query.transact(transactor).unsafeToFuture()
}
