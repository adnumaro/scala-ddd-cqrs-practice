package aphex.lierah.core.module

import org.scalamock.scalatest.MockFactory
import org.scalatest.{Matchers, WordSpec}

protected[module] trait UnitTestCase extends WordSpec with Matchers with MockFactory
