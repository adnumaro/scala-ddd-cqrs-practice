package aphex.lierah.core.module.shared.infrastructure.persistence.doobie

import cats.effect.{Blocker, IO}
import doobie.Transactor
import doobie.util.transactor.Transactor.Aux
import doobie.util.ExecutionContexts

import aphex.lierah.core.module.shared.infrastructure.config.DbConfig

final class DoobieDbConnection(dbConfig: DbConfig) {
  implicit val cs = IO.contextShift(ExecutionContexts.synchronous)

  val transactor: Aux[IO, Unit] = Transactor.fromDriverManager[IO](
    dbConfig.driver,
    dbConfig.host,
    dbConfig.user,
    dbConfig.password,
    Blocker.liftExecutionContext(ExecutionContexts.synchronous) // just for testing
  )
}
