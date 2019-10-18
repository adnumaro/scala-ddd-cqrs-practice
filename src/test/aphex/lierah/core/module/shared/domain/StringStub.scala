package aphex.lierah.core.module.shared.domain

import scala.util.Random

object StringStub {
  def random(numChars: Int): String = Random.alphanumeric take numChars mkString "".trim()
}
