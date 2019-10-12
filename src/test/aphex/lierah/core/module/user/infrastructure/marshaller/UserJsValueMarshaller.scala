package aphex.lierah.core.module.user.infrastructure.marshaller

import spray.json.{JsArray, JsObject, JsString}

import aphex.lierah.core.module.user.domain.User

object UserJsValueMarshaller {
  def marshall(users: Seq[User]): JsArray = JsArray(
    users
      .map(
        user =>
          JsObject(
            "id"   -> JsString(user.id.value.toString),
            "name" -> JsString(user.name.name)
        ))
      .toVector
  )
}
