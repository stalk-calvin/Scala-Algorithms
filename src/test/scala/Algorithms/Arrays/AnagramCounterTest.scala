package Algorithms.Arrays

import org.scalatest.FunSuite

class AnagramCounterTest extends FunSuite {

    val fixture:AnagramCounter = new AnagramCounter

    test("testValidAnagramCounter") {
        assert(fixture.anagramCounter("bat","tab") == 0)
    }

    test("testValidAnagramCounterWithSpace") {
        assert(fixture.anagramCounter("Dormitory","Dirty Room") == 0)
    }

    test("testInvalidAnagramCounter") {
        assert(fixture.anagramCounter("handphone","handmassage") == 10)
    }
}
