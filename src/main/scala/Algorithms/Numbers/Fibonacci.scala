/*
 * Copyright Calvin Lee Since 2017.
 * All Rights Reserved.
 */

package Algorithms.Numbers

class Fibonacci {
    def fibLoop(n: Int): Int = {
        var fibonacci, num = 0
        var num2 = 1
        for (i <- 0 to n) {
            fibonacci = num + num2
            num = num2
            num2 = fibonacci
        }
        num
    }

    def fibRecursive(n: Int): Int = {
        if (n <= 1) 1 else fibRecursive(n - 1) + fibRecursive(n - 2)
    }

    def fibDP(n: Int): Int = {
        if (n <= 1) 1
        var tracker:Array[Int] = new Array[Int](n+1)
        tracker(0) = 1
        tracker(1) = 1
        for (i <- 2 to n) {
            tracker(i) = tracker(i-1) + tracker(i-2)
        }
        tracker(n)
    }
}
