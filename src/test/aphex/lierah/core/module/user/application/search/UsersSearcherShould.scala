package aphex.lierah.core.module.user.application.search

import aphex.lierah.core.module.user.UserUnitTestCase
import aphex.lierah.core.module.user.domain.UserStub

final class UsersSearcherShould extends UserUnitTestCase {
  private val searcher = new UsersSearcher(repository)

  "search all existing users" in {
    val users = UserStub.randomSeq

    repositoryShouldFind(users)

    searcher.all().futureValue shouldBe users
  }
}
