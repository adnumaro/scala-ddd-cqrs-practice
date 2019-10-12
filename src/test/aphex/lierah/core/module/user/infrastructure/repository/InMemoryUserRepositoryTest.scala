package aphex.lierah.core.module.user.infrastructure.repository

import aphex.lierah.core.module.user.UserIntegrationTestCase
import aphex.lierah.core.module.user.domain.UserStub


final class InMemoryUserRepositoryTest extends UserIntegrationTestCase {
  "In memory user repository" should {
    "search all existing users" in {
      val expectedUsers = Seq(
        UserStub(id = "deacd129-d419-4552-9bfc-0723c3c4f56a", name = "Edufasio"),
        UserStub(id = "b62f767f-7160-4405-a4af-39ebb3635c17", name = "Edonisio")
      )

      repository.all() should be(expectedUsers)
    }
  }
}
