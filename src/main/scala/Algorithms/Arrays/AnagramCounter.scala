package Algorithms.Arrays

class AnagramCounter {
    def anagramCounter(s: String, t:String): Int = {
        if (s == null || t == null) 0

        val freq = new Array[Int](26)
        for (c <- s.toLowerCase.replaceAll("\\s", "")) {
            freq(c.toInt - 'a'.toInt) += 1
        }
        for (c <- t.toLowerCase.replaceAll("\\s", "")) {
            freq(c.toInt - 'a'.toInt) -= 1
        }
        var result = 0
        for (i <- freq) {
            result += math.abs(i)
        }
        result
    }
}
