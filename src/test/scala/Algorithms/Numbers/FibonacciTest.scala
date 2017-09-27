/*
 * Copyright Calvin Lee Since 2017.
 * All Rights Reserved.
 */

package Algorithms.Numbers

import org.scalatest.FunSuite

import scala.collection.mutable.ArrayBuffer

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

    test("testListFibonacci") {
        val actual = fixture.listFibonacci(10)
        assert(actual equals ArrayBuffer(0,1,1,2,3,5,8,13,21,34,55))
    }
}
