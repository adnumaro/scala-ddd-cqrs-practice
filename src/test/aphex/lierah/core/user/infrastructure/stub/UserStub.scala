package aphex.lierah.core.user.infrastructure.stub

import aphex.lierah.core.user.domain.User

object UserStub {
  def apply(
      id: String = UserIdStub.random.value.toString,
      name: String = UserNameStub.random.name
  ): User = User(id, name)

  def random: User = apply()
}
