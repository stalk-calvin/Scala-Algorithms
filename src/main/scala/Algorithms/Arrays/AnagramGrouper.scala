package Algorithms.Arrays

import scala.collection.mutable.ArrayBuffer

class AnagramGrouper {
    // Given an array of strings, group anagrams together.
    def anagramGrouper(a:Array[String]):ArrayBuffer[ArrayBuffer[String]] = {
        var result = new ArrayBuffer[ArrayBuffer[String]]()
        if (a == null) result
        var tracker = Map[String, ArrayBuffer[String]]()
        for (item <- a) {
            val sortedItem = item.toLowerCase.sorted
            if (!tracker.contains(sortedItem)) {
                tracker += (sortedItem -> new ArrayBuffer[String]())
            }
            tracker(sortedItem) += item
        }
        var counter = 0
        for ((k,v) <- tracker) {
            result.append(v)
            counter += 1
        }
        result
    }
}
