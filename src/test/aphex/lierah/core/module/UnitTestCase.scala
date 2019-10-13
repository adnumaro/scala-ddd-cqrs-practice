package aphex.lierah.core.module

import org.scalamock.scalatest.MockFactory
import org.scalatest.{Matchers, WordSpec}
import org.scalatest.concurrent.ScalaFutures

protected[module] trait UnitTestCase extends WordSpec with Matchers with ScalaFutures with MockFactory
