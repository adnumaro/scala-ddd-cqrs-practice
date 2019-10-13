package aphex.lierah.core.module.user.domain

import aphex.lierah.core.module.shared.domain.IntStub

object SeqStub {
  def randomOf[T](apply: => T): Seq[T] = (0 to IntStub.randomBetween(1, 2)).map(_ => apply)
}
