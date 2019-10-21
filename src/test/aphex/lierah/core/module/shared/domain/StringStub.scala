package aphex.lierah.core.module.shared.domain

import java.util.Locale

import scala.util.Random

object StringStub {
  val upperAlpha   = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
  val lowerAlpha   = upperAlpha.toLowerCase(Locale.ROOT)
  val numbers      = "0123456789"
  val specialChars = "@#&_-"

  def random(length: Int, minUpper: Int = 0, minLower: Int = 0, minNum: Int = 0, minSpecial: Int = 0): String = {
    val all    = upperAlpha + lowerAlpha + numbers + specialChars
    val result = generateRandom(length, all)

    addComplexityByRules(result, minUpper, minLower, minNum, minSpecial)
  }

  def randomAlphaNumeric(length: Int, minUpper: Int = 0, minLower: Int = 0, minNum: Int = 0): String = {
    val alphaNumeric = upperAlpha + lowerAlpha + numbers
    val result       = generateRandom(length, alphaNumeric)

    addComplexityByRules(result, minUpper, minLower, minNum)
  }

  def randomAlpha(length: Int, minUpper: Int = 0, minLower: Int = 0): String = {
    val alpha  = upperAlpha + lowerAlpha
    val result = generateRandom(length, alpha)

    addComplexityByRules(result, minUpper, minLower)
  }

  def randomLowerAlpha(length: Int, minLower: Int = 0): String = {
    val result = generateRandom(length, lowerAlpha)

    addComplexityByRules(result, minLower)
  }

  def addComplexityByRules(random: String,
                           minUpper: Int = 0,
                           minLower: Int = 0,
                           minNum: Int = 0,
                           minSpecial: Int = 0): String = {
    val randomSeq = random.toSeq

    val upperCharList   = randomSeq.filter(Character.isUpperCase)
    val lowerCharList   = randomSeq.filter(Character.isLowerCase)
    val numberCharList  = randomSeq.filter(Character.isDigit)
    val specialCharList = randomSeq.filter(char => specialChars.contains(char))

    val validRandom = random

    if (minUpper < upperCharList.size) validRandom ++ generateRandom(minUpper - upperCharList.size, upperAlpha)

    if (minLower < lowerCharList.size) validRandom ++ generateRandom(minUpper - lowerCharList.size, lowerAlpha)

    if (minNum < numberCharList.size) validRandom ++ generateRandom(minUpper - numberCharList.size, numbers)

    if (minSpecial < specialCharList.size) validRandom ++ generateRandom(minUpper - specialCharList.size, specialChars)

    validRandom
  }

  def generateRandom(length: Int, chars: String): String =
    (1 to length).map(_ => chars(Random.nextInt.abs % chars.length)).mkString
}
