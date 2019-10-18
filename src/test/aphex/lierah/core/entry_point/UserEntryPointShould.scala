package aphex.lierah.core.entry_point

import akka.http.scaladsl.model._
import doobie.implicits._
import spray.json._

import aphex.lierah.core.module.user.domain.UserStub
import aphex.lierah.core.module.user.infrastructure.marshaller.UserJsValueMarshaller

final class UserEntryPointShould extends AcceptanceSpec {
  private def cleanUsersTable() =
    sql"TRUNCATE TABLE users".update.run
      .transact(doobieDbConnection.transactor)
      .unsafeToFuture()
      .futureValue

  "save a user" in posting(
    "/users",
    """
      |{
      |  "uuid": "a11098af-d352-4cce-8372-2b48b97e6942",
      |  "username": "Aphex user",
      |  "email": "aphex@lierah.com",
      |  "password": "Aphex@Lierah17user"
      |}
    """.stripMargin
  ) {
    status shouldBe StatusCodes.NoContent
  }

  "return all the system users" in {
    cleanUsersTable()

    val users = UserStub.randomSeq

    users.foreach(u => userDependencies.repository.save(u).futureValue)

    getting("/users") {
      status shouldBe StatusCodes.OK
      contentType shouldBe ContentTypes.`application/json`
      entityAs[String].parseJson shouldBe UserJsValueMarshaller.marshall(users)
    }
  }
}
