/*
 * Copyright Calvin Lee Since 2017.
 * All Rights Reserved.
 */

package Algorithms.Numbers

import org.scalatest.FunSuite

class FactorialTest extends FunSuite {

    var fixture: Factorial = new Factorial

    test("testFactRecursive") {
        val actual = fixture.factRecursive(5)
        assert(actual == 120)
    }

    test("testFactPlain") {
        val actual = fixture.factPlain(5)
        assert(actual == 120)
    }

}
