package aphex.lierah.core.module.user.domain

import aphex.lierah.core.module.shared.domain.IntStub

object UserStub {
  def apply(
      id: String = UserIdStub.random.value.toString,
      name: String = UserNameStub.random.name
  ): User = User(id, name)

  def random: User = apply()

  def randomSeq: Seq[User] = (0 to IntStub.randomBetween(1, 20)).map(_ => apply())
}
