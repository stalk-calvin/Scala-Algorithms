package Coursera

import Coursera.Week1
import org.scalatest.FunSuite

class Week1Test extends FunSuite {

    var fixture: Week1 = new Week1

    test("testOr") {
        assert(fixture.or(x = true, y = true))
        assert(fixture.or(x = true, y = false))
        assert(fixture.or(x = false, y = true))
        assert(!fixture.or(x = false, y = false))
    }

    test("testAnd") {
        assert(fixture.and(x = true, y = true))
        assert(!fixture.and(x = true, y = false))
        assert(!fixture.and(x = false, y = true))
        assert(!fixture.and(x = false, y = false))
    }

    test("sqrt") {
        assert(fixture.sqrt(2) == 1.41)
        assert(fixture.sqrt(4) == 2.00)
    }

    test("gcd") {
        assert(fixture.gcd(14,21) == 7)
    }

    test("factorial") {
        assert(fixture.factorial(4) == 24)
    }

    test("factorialTailRecursive") {
        assert(fixture.factorialTailRecursive(4) == 24)
    }

    test("fibonacci_recursive") {
        assert(fixture.fibonacciRecursive(42) == 267914296)
    }

    test("fibonacci_cached") {
        assert(fixture.fibonacciCached(42) == 267914296)
    }
}
