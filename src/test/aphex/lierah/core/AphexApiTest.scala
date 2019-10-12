package aphex.lierah.core

import akka.http.scaladsl.model._
import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.{Matchers, WordSpec}
import org.scalatest.concurrent.ScalaFutures
import spray.json._

import aphex.lierah.core.user.infrastructure.marshaller.UserMarshaller
import aphex.lierah.core.user.infrastructure.stub.UserStub

final class AphexApiTest extends WordSpec with Matchers with ScalaFutures with ScalatestRouteTest {
  "AphexApi" should {
    "respond successfully while requesting its status" in {
      Get("/status") ~> Routes.all ~> check {
        status shouldBe StatusCodes.OK
        contentType shouldBe ContentTypes.`application/json`
        entityAs[String] shouldBe """{"status":"ok"}"""
      }
    }
  }

  "return all the system users" in {
    Get("/users") ~> Routes.all ~> check {
      val expectedUsers = Seq(
        UserStub(id = "deacd129-d419-4552-9bfc-0723c3c4f56a", name = "Edufasio"),
        UserStub(id = "b62f767f-7160-4405-a4af-39ebb3635c17", name = "Edonisio")
      )

      status shouldBe StatusCodes.OK
      contentType shouldBe ContentTypes.`application/json`
      entityAs[String].parseJson shouldBe UserMarshaller.marshall(expectedUsers)
    }
  }
}
