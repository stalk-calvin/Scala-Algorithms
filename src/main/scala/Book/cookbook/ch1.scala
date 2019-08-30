package Book.cookbook

object ch1 extends App {
  implicit class StringImprovements(s: String) {
    def increment: String = s.map(c => (c + 1).toChar)
    def decrement: String = s.map(c => (c - 1).toChar)
    def hideAll: String = s.replaceAll(".", "*")
    def plusOne: Int = s.toInt + 1
    def asBoolean: Boolean = s match {
      case "0" | "zero" | "" | " " => false
      case _ => true
    }
    def printString: Unit = {
      s.foreach(print)
      println()
    }
  }

  val numPattern = "[0-9]+".r
  var result = "123 Main st.".replaceAll("[0-9]", "x")
  result.printString

  result = "HAL".increment
  result.printString

  "4".plusOne.toString.printString

  result = "HAL".hideAll
  result.printString
}
