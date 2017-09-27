package Book.ScalaImpatient

class Ch6 {
    //ex1
    class Conversions {
        def inchesToCentimeters(inches: Double): Double = inches * 2.54

        def gallonsToLiters(gallons: Double): Double = gallons * 3.78541

        def milesToKilometers(miles: Double): Double = miles * 1.60934
    }

    //ex2
    class UnitConversions(val conversionFactor: Double) {
        private def convert(value: Double) = value * conversionFactor

        def apply(value: Double): Double = {
            convert(value)
        }
    }

    object inchesToCentimeters extends UnitConversions(2.54) {}
    object gallonsToLiters extends UnitConversions(3.78541) {}
    object milesToKilometers extends UnitConversions(1.60934) {}

    //ex3 - this extends mutates the object
    object Origin extends java.awt.Point {}

    //ex4
    case class Point(x: Int, y: Int) {
        override def toString: String = "(" + x + ", " + y + ")"
    }

    //ex6
    object CardSuite extends Enumeration {
        type CardSuite = Value
        val Club: Value = Value("♣")
        val Diamond: Value = Value("♦")
        val Heart: Value = Value("♥")
        val Spade: Value = Value("♠")
    }

    //ex7
    class CardSuiteDecorator {

        import CardSuite._

        def isRed(card: CardSuite): Boolean = card == Diamond || card == Heart
    }

    //ex8
    object RGBCube extends Enumeration {
        val Black: Value = Value(0x000000, "Black")
        val Red: Value = Value(0xff0000, "Red")
        val Green: Value = Value(0x00ff00, "Green")
        val Yellow: Value = Value(0xffff00, "Yellow")
        val Blue: Value = Value(0x0000ff, "Blue")
        val Cyan: Value = Value(0x00ffff, "Cyan")
        val Magenta: Value = Value(0xff00ff, "Magenta")
        val White: Value = Value(0xffffff, "White")
        def isRed(a: Value): Boolean = {a.id == 0xff0000}
    }
}

//ex5
object Reverse extends App {
    for(s <- args.reverse) print(s + " ")
    println()
}

