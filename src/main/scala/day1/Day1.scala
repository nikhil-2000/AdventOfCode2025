package day1

import scala.io.Source
import scala.util.{Try, Using}
import Day.DayBase

object Day1 extends DayBase {

  private def directionMultiplier(line: String): Int =
    line.headOption match
      case Some('L') => -1
      case Some('R') => 1
      case _         => 1

  private def amount(line: String): Int =
    tryToInt(line.drop(1)).getOrElse(0)

  private def change(line: String): Int =
    amount(line) * directionMultiplier(line)

  def part1(lines: List[String], start: Int = 50): Int =
    lines
      .foldLeft((start, 0)) { case ((pos, hits), line) =>
        val newPos = Math.floorMod(pos + change(line), 100)
        (newPos, hits + (if newPos == 0 then 1 else 0))
      }
      ._2

  def part2(lines: List[String], start: Int = 50): Int =
    lines
      .foldLeft((start, 0)) { case ((pos, hits), ln) =>
        val delta = change(ln)
        val fullTurns = Math.floorDiv(Math.abs(delta), 100)
        val remainder = delta % 100
        val end = pos + remainder
        val outsideRange = end > 99 || end <= 0
        val cross = if (outsideRange && pos != 0) 1 else 0
        val newPos = Math.floorMod(end, 100)
        (newPos, hits + cross + fullTurns)
      }
      ._2

  def mainDay1(): Unit =
    val day1ExamplesLines = loadLines(filename(1, true))
    val day1Lines = loadLines(filename(1, false))
    println(part1(day1ExamplesLines))
    println(part1(day1Lines))
    println(part2(day1ExamplesLines))
    println(part2(day1Lines))
}