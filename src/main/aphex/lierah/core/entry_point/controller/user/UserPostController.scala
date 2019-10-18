package aphex.lierah.core.entry_point.controller.user

import akka.http.scaladsl.model.HttpResponse
import akka.http.scaladsl.model.StatusCodes.NoContent
import akka.http.scaladsl.server.Directives.complete
import akka.http.scaladsl.server.StandardRoute

import aphex.lierah.core.module.user.application.register.UserRegisterer
import aphex.lierah.core.module.user.domain.value_object._

final class UserPostController(registerer: UserRegisterer) {
  def post(uuid: String, username: String, email: String, password: String): StandardRoute = {
    registerer.register(
      UserUuid(uuid),
      UserUsername(username),
      UserEmail(email),
      UserPassword(password)
    )

    complete(HttpResponse(NoContent))
  }
}
