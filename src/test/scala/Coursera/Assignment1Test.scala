/*
 * Copyright Calvin Lee Since 2017.
 * All Rights Reserved.
 */

package Coursera

import org.scalatest.FunSuite

class Assignment1Test extends FunSuite {

    var fixture: Assignment1 = new Assignment1

    test("testPascal") {
        assert(1 == fixture.pascal(0,2))
        assert(2 == fixture.pascal(1,2))
        assert(3 == fixture.pascal(1,3))
    }

    test("testCountChange") {
        assert(3 == fixture.countChange(4, List(1,2)))
    }

    test("testBalance") {
        assert(fixture.balance(List('(',')')))
        assert(!fixture.balance(List('(','(')))
        assert(!fixture.balance(List(')','(')))
        assert(!fixture.balance(List(')',')')))
        assert(!fixture.balance(List(':','-',')')))
    }

}
