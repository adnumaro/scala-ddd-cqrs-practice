package aphex.lierah.core.module.user.infrastructure.repository

import cats.implicits._
import doobie.implicits._
import doobie.util.update.Update

import aphex.lierah.core.module.shared.infrastructure.persistence.doobie.TypesConversions._
import aphex.lierah.core.module.user.UserIntegrationTestCase
import aphex.lierah.core.module.user.domain.{User, UserStub}

final class DoobieUserRepositoryTest extends UserIntegrationTestCase {
  private def insert(users: Seq[User]) =
    Update[User]("INSERT INTO users(user_id, name) values (?, ?)")
      .updateMany(users.toVector)
      .transact(doobieDbConnection.transactor)
      .unsafeToFuture()
      .futureValue

  private def cleanUsersTable() =
    sql"TRUNCATE TABLE users".update.run
      .transact(doobieDbConnection.transactor)
      .unsafeToFuture()
      .futureValue

  "Doobie user repository" should {
    "return an empty sequence if there're no users" in {
      repository.all().futureValue shouldBe Seq.empty
    }

    "search all existing users" in {
      val expectedUsers = UserStub.randomSeq

      insert(expectedUsers)

      repository.all().futureValue should be(expectedUsers)

      cleanUsersTable()
    }
  }
}
