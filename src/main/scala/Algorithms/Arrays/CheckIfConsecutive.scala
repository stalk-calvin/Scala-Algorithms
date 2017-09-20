package Algorithms.Arrays

class CheckIfConsecutive {
    def areConsecutive(input:Array[Int]): Boolean = {
        if (input == null || input.length < 2) true else input.sorted.sliding(2).count(a => a(0)+1 != a(1)) == 0
    }
}
