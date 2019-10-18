package aphex.lierah.core.module.user.application.register

import aphex.lierah.core.module.user.UserUnitTestCase
import aphex.lierah.core.module.user.domain.UserStub

final class UserRegistererShould extends UserUnitTestCase {
  private val registerer = new UserRegisterer(repository)

  "save user" in {
    val user = UserStub.random

    repositoryShouldSave(user)

    registerer.register(
      user.uuid,
      user.username,
      user.email,
      user.password
    ) shouldBe (())
  }
}
