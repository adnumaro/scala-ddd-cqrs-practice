package aphex.lierah.core.module.user.domain

import scala.concurrent.Future

trait UserRepository {
  def all(): Future[Seq[User]]
}
