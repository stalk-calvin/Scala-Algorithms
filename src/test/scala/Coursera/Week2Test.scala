/*
 * Copyright Calvin Lee Since 2017.
 * All Rights Reserved.
 */

package Coursera

import org.scalatest.FunSuite

class Week2Test extends FunSuite {
    val tolerence = 0.0001

    var fixture: Week2 = new Week2

    test("testSumSqures") {
        assert(14 == fixture.sumSqures(1, 3))
    }

    test("testSumCubes") {
        assert(36 == fixture.sumCubes(1, 3))
    }

    test("testSumInts") {
        assert(6 == fixture.sumInts(1, 3))
    }

    test("testSumSquresCurry") {
        assert(14 == fixture.sumSquresCurry(1, 3))
    }

    test("testSumCubesCurry") {
        assert(36 == fixture.sumCubesCurry(1, 3))
    }

    test("testSumIntsCurry") {
        assert(6 == fixture.sumIntsCurry(1, 3))
    }

    test("testSumItself") {
        assert(6 == fixture.sumItself(x => x)(1, 3))
    }

    test("testProduct") {
        // 2*2 * 3*3 = 36
        assert(36 == fixture.product(x => x * x)(2, 3))
    }

    test("testFactorial") {
        // 4 * 3 * 2 * 1 = 24
        assert(24 == fixture.fact(4))
    }

    test("testFilter") {
        val nums = List(1, 2, 3, 4, 5, 6, 7, 8)
        assert(List(2,4,6,8) == fixture.filter(nums, fixture.modN(2)))
        assert(List(3,6) == fixture.filter(nums, fixture.modN(3)))
    }

    test("testFixedPoint") {
        assert(2-tolerence >= fixture.fixedPoint(x => 1 + x/2)(1))
    }

    test("testSqrtFixedPoint") {
        assert(1.41 < fixture.sqrt(2))
    }
}
