/*
 * Copyright Calvin Lee Since 2017.
 * All Rights Reserved.
 */

package Coursera

import math.abs

class Week2 {
    // 2.1 && 2.2
    private def sum(f: Int => Int, a:Int, b:Int) = {
        def loop(a: Int, acc: Int): Int =
            if (a>b) acc
            else loop(a+1, f(a)+acc)
        loop(a,0)
    }
    def sumInts(a:Int, b:Int) = sum(x => x,a ,b)
    def sumSqures(a:Int, b:Int) = sum(x => x*x,a ,b)
    def sumCubes(a:Int, b:Int) = sum(x => x*x*x,a ,b)

    private def sumCurry(f: Int => Int): (Int, Int) => Int = {
        def sumF(a: Int, b:Int): Int = {
            if (a > b) 0
            else f(a) + sumF(a+1, b)
        }
        sumF
    }
    def sumIntsCurry = sumCurry(x => x)
    def sumSquresCurry = sumCurry(x => x*x)
    def sumCubesCurry = sumCurry(x => x*x*x)

    def sumItself(f: Int => Int)(a:Int, b:Int): Int = {
        if (a > b) 0 else f(a) + sumItself(f)(a+1, b)
    }

    private def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero:Int)(a:Int, b:Int): Int = {
        if (a>b) zero
        else combine(f(a), mapReduce(f, combine, zero)(a+1,b))
    }

    def product(f: Int => Int)(a:Int, b:Int): Int = mapReduce(f, (x,y) => x * y, 1)(a,b)

    def fact(n : Int) = product(x => x)(1, n)

    def filter(xs: List[Int], p: Int => Boolean): List[Int] =
        if (xs.isEmpty) xs
        else if (p(xs.head)) xs.head :: filter(xs.tail, p)
        else filter(xs.tail, p)
    def modN(n: Int)(x: Int) = (x % n) == 0

    // 2.3
    val tolerence = 0.0001
    def isCloseEnough(x:Double, y:Double) = {
        abs((x-y)/x) / x < tolerence
    }
    def fixedPoint(f: Double => Double)(firstGuess:Double) = {
        def iterate(guess:Double):Double = {
            val next = f(guess)
            if (isCloseEnough(guess, next)) next
            else iterate(next)
        }
        iterate(firstGuess)
    }
    def averageDamp(f:Double=>Double)(x:Double) = {
        (x + f(x)) / 2
    }
    def sqrt(x:Double) = fixedPoint(averageDamp(y=>x/y))(1.0)
}
