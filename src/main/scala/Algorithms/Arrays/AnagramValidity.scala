package Algorithms.Arrays

class AnagramValidity {
    def anagramValidity(a:String, b:String): Boolean = {
        a.toLowerCase.replaceAll("\\s", "").sorted equals b.toLowerCase.replaceAll("\\s", "").sorted
    }
}
