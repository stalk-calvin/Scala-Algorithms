/*
 * Copyright Calvin Lee Since 2017.
 * All Rights Reserved.
 */

package Book.ScalaImpatient

import org.scalatest.FunSuite

class Ch1and2Test extends FunSuite {

    val fixture:Ch1and2 = new Ch1and2

    test("testSum") {
        assert(fixture.sum(1,4,9,16,25) == 55)
    }

    test("testSumRecursive") {
        assert(fixture.recursiveSum(1 to 5: _*) == 15)
    }

    test("testSignum") {
        assert(fixture.signum(0) == 0)
        assert(fixture.signum(5) == 1)
        assert(fixture.signum(-5) == -1)
    }

    test("testPrintnum") {
        fixture.printNumbers(10)
    }

    test("testCharacterProduct") {
        assert(fixture.productCharacter("Hello") == 825152896)
    }

    test("testCharacterProductWithoutLoop") {
        assert(fixture.productCharacterWithoutLoop("Hello") == 825152896)
    }

    test("testCharacterProductRecursive") {
        assert(fixture.productCharacterRecursive("Hello") == 825152896)
    }

    test("testCompute") {
        assert(fixture.compute(5, 0) == 1)
        assert(fixture.compute(5, 2) == 25)
        assert(fixture.compute(5, 3) == 125)
        assert(fixture.compute(5, -3) == .008)
    }
}
