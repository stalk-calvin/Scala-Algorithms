/*
 * Copyright Calvin Lee Since 2017.
 * All Rights Reserved.
 */

package Algorithms.scalaimpatient

import scala.math._

class Ch1and2 {
    // star give ability to # of Element like ...
    def sum(args: Int*): Int = {
        var result = 0
        for (arg <- args) result += arg
        result
    }

    def recursiveSum(args: Int*) : Int = {
        if (args.isEmpty) 0
        else args.head + recursiveSum(args.tail : _*)
    }

    def signum(n: Int): Int = {
        if (n == 0) 0
        else if (n < 0) - 1
        else 1
    }

    def printNumbers(n: Int): Unit = {
        for (i <- 10 to 0 by -1) {
            println(i)
        }
        for (i <- 10.to(0,-1)) {
            println(i)
        }
        for (i <- 0 to 10) {
            println(i)
        }
    }

    def productCharacter(string: String): Int = {
        var result = 1
        for(ch <- string) {
            result *= ch.toInt
        }
        result
    }

    def productCharacterWithoutLoop(string: String): Int = {
        var result = 1
        string.foreach(result*=_.toInt)
        result
    }

    def productCharacterRecursive(string: String): Int = {
        if (string.length() == 1) string.head.toInt
        else string.head.toInt * productCharacterRecursive(string.drop(1))
    }

    def compute(x: Double, n: Int): Double = {
        if (n > 0 && n % 2 == 0) pow( pow( x, n / 2 ), 2 )
        else if (n > 0 && n % 2 != 0) x * pow( x, n - 1 )
        else if (n < 0) 1 / pow( x, -n )
        else 1
    }
}
