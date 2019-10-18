package aphex.lierah.core.module.user.domain

object UserStub {
  def random: User = apply()

  def randomSeq: Seq[User] = SeqStub.randomOf(apply())

  def apply(uuid: String = UserUuidStub.random.uuid.toString.trim,
            username: String = UserUsernameStub.random.username.trim,
            email: String = UserEmailStub.random.email.trim,
            password: String = UserPasswordStub.random.password.trim): User = User(uuid, username, email, password)
}
