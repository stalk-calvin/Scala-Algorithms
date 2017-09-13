/*
 * Copyright Calvin Lee Since 2017.
 * All Rights Reserved.
 */

package Algorithms.Numbers

class Factorial {
    def factPlain(n : Int): Int = {
        var r = 1
        for (i <- 1 to n) r = r * i
        r
    }

    def factRecursive(n: Int): Int = {
        if (n == 0) 1 else n * factRecursive(n - 1)
    }
}
