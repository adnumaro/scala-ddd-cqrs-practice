package aphex.lierah.core

import org.scalatest._
import org.scalatest.Matchers._

final class GreetingsTest extends WordSpec with GivenWhenThen {

  "Greetings" should {
    "say hello" in {
      Given("a Greetings")

      val greetings = Greetings("Javi")

      When("we ask him to greet")

      val greeting = greetings.greet()

      Then("he should say hello")

      greeting shouldBe "Hello"
    }
  }
}
