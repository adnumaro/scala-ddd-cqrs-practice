package aphex.lierah.core.module.user

import scala.concurrent.Future

import aphex.lierah.core.module.UnitTestCase
import aphex.lierah.core.module.user.domain.{User, UserRepository}

protected[user] trait UserUnitTestCase extends UnitTestCase {
  protected val repository: UserRepository = mock[UserRepository]

  protected def repositoryShouldFind(users: Seq[User]): Unit =
    (() => repository.all())
      .expects()
      .returning(Future.successful(users))

  protected def repositoryShouldSave(user: User): Unit =
    (repository.save _)
      .expects(user)
      .returning(Future.unit)
}
