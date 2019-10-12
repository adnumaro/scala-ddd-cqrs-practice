package aphex.lierah.core.module.user.domain

trait UserRepository {
  def all(): Seq[User]
}
