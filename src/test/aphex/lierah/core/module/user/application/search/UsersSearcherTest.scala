package aphex.lierah.core.module.user.application.search

import aphex.lierah.core.module.user.UserUnitTestCase
import aphex.lierah.core.module.user.domain.UserStub

final class UsersSearcherTest extends UserUnitTestCase {
  private val searcher = new UsersSearcher(repository)

  "Users Searcher" should {
    "search all existing users" in {
      val existingUser        = UserStub.random
      val anotherExistingUser = UserStub.random
      val existingUsers       = Seq(existingUser, anotherExistingUser)

      shouldSearchAllUsers(existingUsers)

      searcher.all().futureValue should be(existingUsers)
    }
  }
}
