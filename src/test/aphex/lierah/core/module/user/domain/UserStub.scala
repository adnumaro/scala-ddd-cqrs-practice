package aphex.lierah.core.module.user.domain

object UserStub {
  def apply(
      id: String = UserIdStub.random.value.toString,
      name: String = UserNameStub.random.name
  ): User = User(id, name)

  def random: User = apply()
}
