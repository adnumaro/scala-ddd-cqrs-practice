package aphex.lierah.core.entry_point

import aphex.lierah.core.entry_point.controller.status.StatusGetController
import aphex.lierah.core.entry_point.controller.user.UserGetController
import aphex.lierah.core.module.user.infrastructure.dependency_injection.UserModuleDependencyContainer

final class EntryPointDependencyContainer(
    userDependencies: UserModuleDependencyContainer
) {
  val statusGetController = new StatusGetController

  val userGetController = new UserGetController(userDependencies.usersSearcher)
}
