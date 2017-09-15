/*
 * Copyright Calvin Lee Since 2017.
 * All Rights Reserved.
 */

package Book.ScalaImpatient

import org.scalatest.FunSuite
import scala.collection.mutable.ArrayBuffer

class Ch3Test extends FunSuite {

    val fixture:Ch3 = new Ch3

    test("testReverseSortedWithArray") {
        val a = Array(1,2,3,4,5)
        assert(fixture.reverseSorted(a).sameElements(Array(5, 4, 3, 2, 1)))
    }

    test("testReverseSortedWithArrayBuffer") {
        val a = ArrayBuffer(1,2,3,4,5)
        assert(fixture.reverseSorted(a).equals(ArrayBuffer(5, 4, 3, 2, 1)))
    }

    test("testRemoveNegativeExceptFirstOne") {
        val a = ArrayBuffer(1,-1,4,5,-9,-7,11,2,-8)
        assert(fixture.removeNegativeExceptFirstOne(a).equals(ArrayBuffer(1,-1,4,5,11,2)))
    }

    test("testGetAverage") {
        val a = Array(1.0,2.0,3.0,4.0,5.0)
        assert(fixture.getAverage(a) == 3.0)
    }

    test("testSwapAdjacentWithNew") {
        val a = Array(1,2,3,4,5)
        assert(fixture.swapAdjacentWithNew(a).equals(List(2,1,4,3,5)))
    }

    test("testSwapAdjacent") {
        val a = Array(1,2,3,4,5)
        assert(fixture.swapAdjacent(a).sameElements(Array(2,1,4,3,5)))
    }

    test("testMakeArray") {
        val n = 5
        val result = fixture.makeArray(n)
        for (i <- 0 until n) {
            assert(i<=n)
        }
    }

    test("testRemoveDuplicate") {
        val a = Array(1,1,1,2,3,4,4,5)
        assert(fixture.removeDuplicate(a) sameElements Array(1,2,3,4,5))
    }

    test("testGetAvailableAmericanTimezone") {
        for (item <- fixture.getAvailableAmericanTimezone) {
            println("Analyze: " + item)
            assert(!item.startsWith("America/"))
        }
    }

    test("testPutPositiveFront") {
        val a = ArrayBuffer(1,-1,4,5,-9,-7,11,2,-8)
        assert(fixture.putPositiveFront(a) equals ArrayBuffer(1,4,5,11,2,-8,-7,-9,-1))
    }

}
