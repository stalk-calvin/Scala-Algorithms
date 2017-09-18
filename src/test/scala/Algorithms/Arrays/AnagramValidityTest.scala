package Algorithms.Arrays

import org.scalatest.FunSuite

class AnagramValidityTest extends FunSuite {

    val fixture:AnagramValidity = new AnagramValidity

    test("testAnagramValidity") {
        assert(fixture.anagramValidity("tab","bat"))
    }

    test("testAnagramValidityWithSpaceAndCapital") {
        assert(fixture.anagramValidity("Dormitory","Dirty Room"))
    }

    test("testInvalidAnagramValidity") {
        assert(!fixture.anagramValidity("car","bat"))
    }
}
