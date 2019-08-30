package Book.cookbook

import com.github.nscala_time.time.Imports._

object ch2 extends App {
  implicit class StringUtils(s: String) {
    def toInt(radix: Int): Int = Integer.parseInt(s, radix)
    def printString(): Unit = {
      s.foreach(print)
      println()
    }
  }

  def toInt(s: String):Option[Int] = {
    try {
      Some(s.toInt(10))
    } catch {
      case e: NumberFormatException => None
    }
  }

  DateTime.now.toString.printString() // returns org.joda.time.DateTime
  (DateTime.now + 2.months).toString.printString()
  //DateTime.nextMonth < DateTime.now + 2.months
  (2.hours + 45.minutes + 10.seconds).millis.toString.printString()
  println("100".toInt(16))
  println(toInt("a").getOrElse(0))
  19.45.toInt.toString.printString()

  var x = 1d
  x.toString.printString()

  x=1f
  x.toString.printString()

  x=1L
  x.toString.printString()

  val r = 1 to 10 by 3
  r.foreach(println)

  val numLocale = new java.util.Locale("kr", "KR")
  val numFormatter = java.text.NumberFormat.getIntegerInstance(numLocale)
  numFormatter.format(1000000).printString()

  val currencyLocale = new java.util.Locale("us", "US")
  val currencyFormatter = java.text.NumberFormat.getCurrencyInstance(currencyLocale)
  println(currencyFormatter.format(123.456789))
}
