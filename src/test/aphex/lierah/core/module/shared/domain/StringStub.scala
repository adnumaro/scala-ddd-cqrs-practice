package aphex.lierah.core.module.shared.domain

import java.util.Locale

import scala.util.Random

object StringStub {
  val upperAlpha   = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
  val lowerAlpha   = upperAlpha.toLowerCase(Locale.ROOT)
  val numbers      = "0123456789"
  val specialChars = "@#&_-"

  def random(length: Int, minUpper: Int = 0, minLower: Int = 0, minNum: Int = 0, minSpecial: Int = 0): String = {
    val all = upperAlpha + lowerAlpha + numbers + specialChars
    val result = generateRandom(length, all)

    addComplexityByRules(result, minUpper, minLower, minNum, minSpecial)
  }

  def randomAlphaNumeric(length: Int, minUpper: Int = 0, minLower: Int = 0, minNum: Int = 0): String = {
    val alphaNumeric = upperAlpha + lowerAlpha + numbers
    val result = generateRandom(length, alphaNumeric)

    addComplexityByRules(result, minUpper, minLower, minNum)
  }

  def randomAlpha(length: Int, minUpper: Int = 0, minLower: Int = 0): String = {
    val alpha = upperAlpha + lowerAlpha
    val result = generateRandom(length, alpha)

    addComplexityByRules(result, minUpper, minLower)
  }

  def randomLowerAlpha(length: Int, minLower: Int = 0): String = {
    val result = generateRandom(length, lowerAlpha)

    addComplexityByRules(result, minLower)
  }

  def generateRandom(length: Int, chars: String): String =
    (1 to length).map(_ => chars(Random.nextInt.abs % chars.length)).mkString

  def addComplexityByRules(random: String,
                           minUpper: Int = 0,
                           minLower: Int = 0,
                           minNum: Int = 0,
                           minSpecial: Int = 0): String = {
    var validRandom = random

    if (minUpper > 0 && !validRandom.matches(s"(.*?[A-Z]){${minUpper},}")) validRandom += "A"

    if (minLower > 0 && !validRandom.matches(s"(.*?[a-z]){${minUpper},}")) validRandom += "a"

    if (minNum > 0 && !validRandom.matches(s"(.*?[0-9]){${minUpper},}")) validRandom += "1"

    if (minSpecial > 0 && !validRandom.matches(s"(.*?[@#&\\_-]){${minSpecial},}")) validRandom += "@"

    validRandom
  }
}
