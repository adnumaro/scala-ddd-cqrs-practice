package aphex.lierah.core.module.user

import aphex.lierah.core.module.UnitTestCase
import aphex.lierah.core.module.user.domain.{User, UserRepository}

protected[user] trait UserUnitTestCase extends UnitTestCase {
  protected val repository: UserRepository = mock[UserRepository]

  protected def shouldSearchAllUsers(users: Seq[User]): Unit =
    (() => repository.all())
      .expects()
      .returning(users)
}