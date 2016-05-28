package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int = (c, r) match {
    case (0, _) => 1
    case (x, y) if (x == y) => 1
    case default => pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {

    def balance(chars: List[Char], open: Int): Boolean = {
      if (chars.isEmpty) return open == 0
      else if (chars.head.equals('(')) balance(chars.tail, open + 1)
      else if (chars.head.equals(')')) open > 0 && balance(chars.tail, open - 1)
      else balance(chars.tail, open)
    }

    balance(chars, 0)
  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = {

    def countChangeRec(money: Int, coins: List[Int]): Int = {
      if (coins.isEmpty) {
        return 0
      } else {
        if (money == coins.head) 1
        else if (coins.head > money) return 0
        else countChangeRec(money - coins.head, coins) + countChange(money, coins.tail)
      }
    }

    return countChangeRec(money, coins.sortWith(_.compareTo(_) < 0))

  }
}