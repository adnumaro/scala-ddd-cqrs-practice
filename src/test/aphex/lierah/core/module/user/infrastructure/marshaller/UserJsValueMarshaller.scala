package aphex.lierah.core.module.user.infrastructure.marshaller

import spray.json.{JsArray, JsObject, JsString}

import aphex.lierah.core.module.user.domain.User

object UserJsValueMarshaller {
  def marshall(users: Seq[User]): JsArray = JsArray(
    users
      .map(
        user =>
          JsObject(
            "uuid"     -> JsString(user.uuid.uuid.toString),
            "username" -> JsString(user.username.username),
            "email"    -> JsString(user.email.email),
            "password" -> JsString(user.password.password)
        ))
      .toVector
  )
}
