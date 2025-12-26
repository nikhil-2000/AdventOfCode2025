
import scala.util.Try
import Day.DayBase
import scala.annotation.tailrec
import scala.math.BigInt

object Day3 extends DayBase {

  def helper(digits: Vector[Int], digitsLeft: Int): Long = 
    if digitsLeft == 1 then return digits.max.toLong
    val searchWindow = (digits.length - digitsLeft) + 1
    val left = digits.take(searchWindow)
    val rest = digits.drop(searchWindow)
    val (_, remWithMax) = digits.span(_ != left.max)
    val rem = remWithMax.drop(1)
    return (left.max * math.pow(10, digitsLeft - 1).toLong) + helper(rem, digitsLeft - 1)

  def findMaxN(bank: String, size:Int = 12): Long = 
    val digits = bank.map(_.asDigit).toVector
    helper(digits, size)

  def part1(banks: List[String]): BigInt =  banks.map(bank => findMaxN(bank, 2)).reduce(_ + _)

  def part2(banks: List[String]): BigInt = banks.map(bank => findMaxN(bank, 12)).reduce(_ + _)

  def mainDay3(): Unit =
    val exampleLines = loadLines(filename(3, true))
    val inputLines = loadLines(filename(3, false))
    println(part1(exampleLines))
    println(part1(inputLines))
    println(part2(exampleLines))
    println(part2(inputLines))
}
