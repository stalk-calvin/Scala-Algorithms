package Algorithms.Arrays

import org.scalatest.FunSuite

class CheckIfConsecutiveTest extends FunSuite {

    val fixture:CheckIfConsecutive = new CheckIfConsecutive
    
    test("shouldNotBeConsecutive") {
        val input: Array[Int] = Array(72, 78, 76, 77, 73, 74)
        assert(!fixture.areConsecutive(input))
    }

    test("shouldNotBeConsecutiveContainsDuplicate") {
        val input: Array[Int] = Array(76, 78, 76, 77, 73, 74)
        assert(!fixture.areConsecutive(input))
    }

    test("shouldBeConsecutive") {
        val input: Array[Int] = Array(76, 78, 75, 77, 73, 74, 81, 80, 79, 72)
        assert(fixture.areConsecutive(input))
    }

    test("shouldQuitAfterLongDistance") {
        val input: Array[Int] = Array(1, 78, 76, 77, 73, 74)
        assert(!fixture.areConsecutive(input))
    }
}
