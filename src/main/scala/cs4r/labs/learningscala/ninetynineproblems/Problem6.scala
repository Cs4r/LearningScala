package cs4r.labs.learningscala.ninetynineproblems

import scala.annotation.tailrec

/**
  * Find out whether a list is a palindrome.
  */
object Problem6 {
  def isPalindrome[T](list: List[T]): Boolean = {
    @tailrec
    def isPalindromeTailRecursive(b: Boolean, list: List[T]): Boolean = (b, list) match {
      case (false, list) => false
      case (true, Nil) => true
      case (true, x :: Nil) => true
      case (true, x :: tail) => isPalindromeTailRecursive(x == tail.last, tail.init)
    }

    isPalindromeTailRecursive(true, list)
  }
}
