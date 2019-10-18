package aphex.lierah.core.module.user.application.search

import aphex.lierah.core.module.user.UserUnitTestCase
import aphex.lierah.core.module.user.domain.UserStub

final class UsersSearcherShould extends UserUnitTestCase {
  private val searcher = new UsersSearcher(repository)

  "search all existing users" in {
    val user        = UserStub.random
    val anotherUser = UserStub.random
    val users       = Seq(user, anotherUser)

    repositoryShouldFind(users)

    searcher.all().futureValue shouldBe users
  }
}
