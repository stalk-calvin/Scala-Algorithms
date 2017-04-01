package Coursera

import scala.annotation.tailrec

class Assignment1 {
    // Exercise 1
    def pascal(col: Int, row: Int): Int = {
        if (col == 0 || col == row) 1
        else pascal(col - 1, row - 1) + pascal(col, row - 1)
    }

    // Exercise 2
    def balance(chars: List[Char]): Boolean = {
        @tailrec
        def balanced(chars: List[Char], open: Int): Boolean =
            if (chars.isEmpty) open == 0
            else if (chars.head == '(') balanced(chars.tail,open+1)
            else if (chars.head == ')') open>0 && balanced(chars.tail,open-1)
            else balanced(chars.tail,open)
        balanced(chars,0)
    }

    // Exercise 3
    def countChange(money: Int, coins: List[Int]): Int = {
        if (coins.isEmpty || money < 0) return 0
        if (money == 0) return 1
        countChange(money - coins.head, coins) + countChange(money, coins.tail)
    }
}
