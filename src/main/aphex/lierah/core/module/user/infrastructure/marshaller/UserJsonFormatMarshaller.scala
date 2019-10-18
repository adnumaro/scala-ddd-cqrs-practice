package aphex.lierah.core.module.user.infrastructure.marshaller

import java.util.UUID

import spray.json.{DeserializationException, JsonFormat, JsString, JsValue, RootJsonFormat}
import spray.json.DefaultJsonProtocol._

import aphex.lierah.core.module.user.domain.User
import aphex.lierah.core.module.user.domain.value_object._

object UserJsonFormatMarshaller {

  implicit object UserUsernameMarshaller extends JsonFormat[UserUsername] {
    def write(value: UserUsername): JsValue = JsString(value.username)

    def read(value: JsValue): UserUsername = value match {
      case JsString(username) => UserUsername(username)
      case _                  => throw DeserializationException("Expected 1 string for UserUsername")
    }
  }

  implicit object UserEmailMarshaller extends JsonFormat[UserEmail] {
    def write(value: UserEmail): JsValue = JsString(value.email)

    def read(value: JsValue): UserEmail = value match {
      case JsString(email) => UserEmail(email)
      case _               => throw DeserializationException("Expected 1 string for UserEmail")
    }
  }

  implicit object UserPasswordMarshaller extends JsonFormat[UserPassword] {
    def write(value: UserPassword): JsValue = JsString(value.password)

    def read(value: JsValue): UserPassword = value match {
      case JsString(password) => UserPassword(password)
      case _                  => throw DeserializationException("Expected 1 string for UserPassword")
    }
  }

  implicit object UuidMarshaller extends JsonFormat[UUID] {
    def write(value: UUID): JsValue = JsString(value.toString)

    def read(value: JsValue): UUID = value match {
      case JsString(uuid) => UUID.fromString(uuid)
      case _              => throw DeserializationException("Expected hexadecimal UUID string")
    }
  }

  implicit object UserUuidMarshaller extends JsonFormat[UserUuid] {
    def write(value: UserUuid): JsValue = JsString(value.uuid.toString)

    def read(value: JsValue): UserUuid = value match {
      case JsString(uuid) => UserUuid(uuid)
      case _              => throw DeserializationException("Expected 1 string for UserUuid")
    }
  }

  implicit val userFormat: RootJsonFormat[User] = jsonFormat4(
    User.apply(_: UserUuid, _: UserUsername, _: UserEmail, _: UserPassword))
}
