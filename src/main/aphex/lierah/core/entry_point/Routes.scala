package aphex.lierah.core.entry_point

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import spray.json.DefaultJsonProtocol._
import spray.json.JsValue

final class Routes(container: EntryPointDependencyContainer) {
  private val status =
    get {
      path("status")(container.statusGetController.get())
    }
  private val user =
    get {
      path("users")(container.userGetController.get())
    } ~
      post {
        path("users") {
          jsonBody { body =>
            container.userPostController.post(
              body("id").convertTo[String],
              body("name").convertTo[String]
            )
          }
        }
      }

  private def jsonBody(handler: Map[String, JsValue] => Route): Route =
    entity(as[JsValue])(json => handler(json.asJsObject.fields))

  val all: Route = status ~ user
}
