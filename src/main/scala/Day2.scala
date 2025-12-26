
import scala.util.Try
import Day.DayBase
import scala.annotation.tailrec
import scala.math.BigInt

object Day2 extends DayBase {

  private def toNumbers(range: String): Seq[String] =
    val Array(lowS, highS) = range.split('-')
    val low = lowS.toLong
    val high = highS.toLong
    (low to high).map(_.toString)

  private def parseRanges(lines: List[String]): Seq[String] =
    lines.headOption
      .map(_.split(',').toSeq.flatMap(toNumbers))
      .getOrElse(Seq.empty)

  private def restMatches(pattern: String, rest: String): Boolean =
    val l = pattern.length
    (rest.length % l == 0) && (rest == pattern.repeat(rest.length / l))

  private def isInvalid(num: String): Boolean =
    val l = num.length
    l % 2 == 0 && num.take(l / 2) == num.drop(l / 2)

  private def isInvalid2(num: String): Boolean =
    (1 until num.length).exists(i => restMatches(num.take(i), num.drop(i)))

  def part1(lines: List[String]): BigInt =
    parseRanges(lines).filter(isInvalid).map(BigInt(_)).sum

  def part2(lines: List[String]): BigInt =
    parseRanges(lines).filter(isInvalid2).map(BigInt(_)).sum

  def mainDay2(): Unit =
    val exampleLines = loadLines(filename(2, true))
    val inputLines = loadLines(filename(2, false))
    println(part1(exampleLines))
    println(part1(inputLines))
    println(part2(exampleLines))
    println(part2(inputLines))
}
