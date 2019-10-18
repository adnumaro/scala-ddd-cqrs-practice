package aphex.lierah.core.module.user.infrastructure.repository

import doobie.implicits._

import aphex.lierah.core.module.user.UserIntegrationTestCase
import aphex.lierah.core.module.user.domain.UserStub

final class DoobieUserRepositoryShould extends UserIntegrationTestCase {
  private def cleanUsersTable() =
    sql"TRUNCATE TABLE users".update.run
      .transact(doobieDbConnection.transactor)
      .unsafeToFuture()
      .futureValue

  "return an empty sequence if there're no users" in {
    cleanUsersTable()

    repository.all().futureValue shouldBe Seq.empty
  }

  "search all existing users" in {
    cleanUsersTable()

    val users = UserStub.randomSeq

    users.foreach(user => repository.save(user).futureValue)

    repository.all().futureValue shouldBe users
  }
}
