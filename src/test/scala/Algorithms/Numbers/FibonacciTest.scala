/*
 * Copyright Calvin Lee Since 2017.
 * All Rights Reserved.
 */

package Algorithms.Numbers

import org.scalatest.FunSuite

class FibonacciTest extends FunSuite {

    val fixture: Fibonacci = new Fibonacci

    test("testFibLoop") {
        val actual = fixture.fibLoop(5)
        assert(actual == 8)
    }

    test("testFibRecursive") {
        val actual = fixture.fibRecursive(5)
        assert(actual == 8)
    }

    test("testFibDP") {
        val actual = fixture.fibDP(5)
        assert(actual == 8)
    }
}
