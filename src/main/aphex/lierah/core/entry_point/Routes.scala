package aphex.lierah.core.entry_point

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route

final class Routes(container: EntryPointDependencyContainer) {
  private val status =
    get {
      path("status")(container.statusGetController.get())
    }

  private val user =
    get {
      path("users")(container.userGetController.get())
    }

  val all: Route = status ~ user
}
