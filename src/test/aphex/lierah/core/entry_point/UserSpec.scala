package aphex.lierah.core.entry_point

import akka.http.scaladsl.model._
import doobie.util.update.Update
import spray.json._
import doobie.implicits._
import cats.implicits._

import aphex.lierah.core.module.user.domain.{User, UserStub}
import aphex.lierah.core.module.user.infrastructure.marshaller.UserJsValueMarshaller
import aphex.lierah.core.module.shared.infrastructure.persistence.doobie.TypesConversions._

final class UserSpec extends AcceptanceSpec {
  private val expectedUsers = UserStub.randomSeq

  override def beforeAll(): Unit = {
    super.beforeAll()

    def insertExpectedUsers() =
      Update[User]("INSERT INTO users(user_id, name) values (?, ?)")
        .updateMany(expectedUsers.toVector)
        .transact(doobieDbConnection.transactor)
        .unsafeToFuture()
        .futureValue

    insertExpectedUsers()
  }

  override def afterAll(): Unit = {
    super.afterAll()

    def truncateUsersTable() =
      sql"TRUNCATE TABLE users".update.run
        .transact(doobieDbConnection.transactor)
        .unsafeToFuture()
        .futureValue

    truncateUsersTable()
  }

  "return all the system users" in getting("/users") {
    status shouldBe StatusCodes.OK
    contentType shouldBe ContentTypes.`application/json`
    entityAs[String].parseJson shouldBe UserJsValueMarshaller.marshall(expectedUsers)
  }
}
