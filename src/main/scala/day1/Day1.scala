package day1

import scala.io.Source
import scala.util.{Try, Using}

object Day1:
  private def tryToInt(s: String): Option[Int] =
    Try(s.toInt).toOption

  private def loadLines(resource: String): List[String] =
    Using.resource(Source.fromResource(resource))(_.getLines().toList)

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

  def filename(example: Boolean) =
    example match
      case true  => "day1 example.txt"
      case false => "day1.txt"

  def part1ForFile(example: Boolean = false) = part1(
    loadLines(filename(example))
  )
  
  def part2ForFile(example: Boolean = false) = part2(
    loadLines(filename(example))
  )

  def main(args: Array[String]): Unit =
    println(part1ForFile(true))
    println(part1ForFile(false))
    println(part2ForFile(true))
    println(part2ForFile(false))
