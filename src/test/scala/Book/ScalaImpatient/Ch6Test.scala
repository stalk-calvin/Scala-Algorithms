package Book.ScalaImpatient

import org.scalatest.FunSuite

class Ch6Test extends FunSuite {
    val fixture: Ch6 = new Ch6

    test("testPlainConversions") {
        val plainCoversions = new fixture.Conversions
        assert(BigDecimal(plainCoversions.gallonsToLiters(10)).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble == 37.85)
        assert(BigDecimal(plainCoversions.inchesToCentimeters(10)).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble == 25.40)
        assert(BigDecimal(plainCoversions.milesToKilometers(10)).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble == 16.09)
    }

    test("testUnitConversions") {
        assert(BigDecimal(fixture.gallonsToLiters(10)).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble == 37.85)
        assert(BigDecimal(fixture.inchesToCentimeters(10)).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble ==
          25.40)
        assert(BigDecimal(fixture.milesToKilometers(10)).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble == 16.09)
    }

    test("testNewPoint") {
        assert(fixture.Point(2,3).toString equals "(2, 3)")
    }

    test("testCardSuite") {
        assert(fixture.CardSuite.Club.toString equals "♣")
        assert(fixture.CardSuite.Spade.toString equals "♠")
    }

    test("testCardSuiteDecorator") {
        val cardSuite = new fixture.CardSuiteDecorator
        assert(cardSuite.isRed(fixture.CardSuite.Diamond))
    }

    test("testRGBCube") {
        assert(fixture.RGBCube.Red.id == 0xff0000)
        assert(fixture.RGBCube.Red.toString == "Red")
        assert(fixture.RGBCube.isRed(fixture.RGBCube.Red))
        assert(!fixture.RGBCube.isRed(fixture.RGBCube.Black))
    }
}
