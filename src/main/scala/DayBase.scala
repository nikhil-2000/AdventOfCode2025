package Day

import scala.util.Using
import scala.io.Source
import scala.util.Try

class DayBase {
  def filename(day: Int, example: Boolean): String = {
    val prefix = "day" + day.toString()
    example match {
      case true  => prefix + "-example.txt"
      case false => prefix + ".txt"
    }
  }

  def loadLines(resource: String): List[String] =
    Using.resource(Source.fromResource(resource))(_.getLines().toList)

  def tryToInt(s: String): Option[Int] = Try(s.toInt).toOption
}
