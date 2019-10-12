package aphex.lierah.core.user.infrastructure.marshaller

import spray.json.{JsArray, JsObject, JsString}

import aphex.lierah.core.user.domain.User

object UserMarshaller {
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
