package Algorithms.Arrays

class CheckIfConsecutive {
    def areConsecutive(input:Array[Int]): Boolean = {
        if (input == null || input.length < 2) return true
        var tracker: Set[Int] = Set()
        var min = Int.MaxValue
        for (item <- input) {
            if (tracker.contains(item)) {
                return false
            }
            tracker += item
            min = math.min(min, item)
        }
        for (i <- min until min + input.length) {
            if (!tracker.contains(i)) {
                return false
            }
        }
        true
    }
}