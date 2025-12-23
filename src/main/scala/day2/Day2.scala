package day2

import scala.io.Source
import scala.util.{Try, Using}
import Day.DayBase

class Day2 extends DayBase {

  def toNumbers(range: String) =
    val lowHigh = range.split('-')
    val lowString = lowHigh.head
    val highString = lowHigh.drop(1).head
    val low = lowString.toLong
    val high = highString.toLong + 1
    (low until high).map(_.toString)
  
  def isInvalid(num: String): Boolean = 
      val l = num.length();
      if (l % 2 != 0) return false
      val parts = num.grouped(l / 2).toList
      val start = parts.head;
      val end = parts.drop(1).head;
      start == end;

  def isInvalid_2(num: String): Boolean = 
    val lengths = 1 until num.length()
    lengths.exists(i => restMatches(num.take(i), num.drop(i)))

  def restMatches(pattern: String, rest: String): Boolean =
    if (rest.length < pattern.length) false
    else if (rest.startsWith(pattern)) {
      val remaining = rest.substring(pattern.length)
      if (remaining.isEmpty) true else restMatches(pattern, remaining)
    } else false
  
  def part1(line: List[String]) = {
    val ranges = line.head.split(",")
    val allNums = ranges.flatMap(toNumbers(_))
    val invalids = allNums.filter(isInvalid).toList.map(_.toLong)
    println(invalids.sum)
  }

  def part2(line: List[String]) = {
    val ranges = line.head.split(",")
    val allNums = ranges.flatMap(toNumbers(_))
    val invalids = allNums.filter(isInvalid_2).toList.map(_.toLong)
    println(invalids.sum)
  }

  def main(): Unit =
    val day2ExamplesLines = loadLines(filename(2, true))
    val day2Lines = loadLines(filename(2, false))

    part1(day2ExamplesLines)
    part1(day2Lines)
    part2(day2ExamplesLines)
    part2(day2Lines)
}
