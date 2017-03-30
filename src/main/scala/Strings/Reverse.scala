package Strings

class Reverse {
    def reverseString1(s: String): String = {
        val charArray: Array[Char] = s.toCharArray
        var start: Int = 0
        var end: Int = charArray.length - 1
        while (start <= end) {
            // Swapping start and end
            val tmp: Char = charArray(start)
            charArray(start) = charArray(end)
            charArray(end) = tmp
            start += 1
            end -= 1
        }
        new String(charArray)
    }

    def reverseString2(in: String): String = {
        if (in == null || in.length < 2) return in
        val result: StringBuilder = new StringBuilder(in)
        result.reverse.toString
    }

    def reverseString3(in: String): String = {
        if (in == null || in.length < 2) return in
        val result: StringBuilder = new StringBuilder
        var i: Int = in.length - 1
        while (i >= 0) {
            {
                result.append(in.charAt(i))
            }
            {
                i -= 1
                i + 1
            }
        }
        result.toString
    }
}
