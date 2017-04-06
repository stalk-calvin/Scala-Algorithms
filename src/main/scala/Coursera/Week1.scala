/*
 * Copyright Calvin Lee Since 2017.
 * All Rights Reserved.
 */

package Coursera

class Week1 {
    def and(x: Boolean, y: Boolean) = if (x) y else false

    def or(x: Boolean, y: Boolean) = if (x) true else y

    def abs(x: Double) = if (x < 0) -x else x

    def sqrt(x: Double) = {
        def sqrtIter(guess: Double): Double = {
            if (isGoodEnough(guess)) guess
            else sqrtIter(improve(guess))
        }

        def isGoodEnough(guess: Double) = {
            abs(guess * guess - x) / x < 0.001
        }

        def improve(guess: Double) = {
            (guess + x / guess) / 2
        }

        val number = sqrtIter(1.0)
        (number * 100).round / 100.toDouble
    }

    def gcd(a: Int, b:Int): Int = {
        if (b==0) a
        else
            gcd(b, a%b)
    }

    def factorial(n: Int): Int = {
        if (n==0) 1
        else
            n * factorial(n-1)
    }

    def factorialTailRecursive(n:Int): Int = {
        def loop(acc: Int, n: Int): Int = {
            if (n == 0) acc
            else loop(acc * n, n - 1)
        }
        loop(1, n)
    }

    def fibonacciRecursive( n : Int) : Int = n match {
        case 0 | 1 => n
        case _ => fibonacciRecursive( n-1 ) + fibonacciRecursive( n-2 )
    }

    def fibonacciCached(n: Int): Int = {
        if (n == 1 || n == 2) 1
        var n0 = 1
        var n1 = 1
        for (i <- 2 until n) {
            var temp = n1
            n1 = n0 + n1
            n0 = temp
        }
        n1
    }

}
