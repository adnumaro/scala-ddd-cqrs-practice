package aphex.lierah.core.module.user.domain

object UserStub {
  def random: User = apply()

  def apply(uuid: String = UserUuidStub.random.uuid.toString,
            username: String = UserUsernameStub.random.username,
            email: String = UserEmailStub.random.email,
            password: String = UserPasswordStub.random.passwordHashed): User =
    User(uuid, username, email, password)

  def randomSeq: Seq[User] = SeqStub.randomOf(apply())
}
