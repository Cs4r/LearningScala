package cs4r.labs.learningscala.ninetynineproblems

import java.util.NoSuchElementException

/**
  * Remove the Kth element from a list.
  */
object Problem20 {

  def main(args: Array[String]) {
    println(removeAt1(1, List('a, 'b, 'c, 'd)))
    println(removeAt2(1, List('a, 'b, 'c, 'd)))
    println(removeAt3(1, List('a, 'b, 'c, 'd)))
  }

  def removeAt1[T](n: Int, list: List[T]): (List[T], T) = {
    (list.take(n) ++ list.drop(n + 1), list(n))
  }

  def removeAt2[T](n: Int, list: List[T]): (List[T], T) = list.splitAt(n) match {
    case (Nil, _) => throw new NoSuchElementException
    case (_, Nil) => throw new NoSuchElementException
    case (head, e :: tail) => (head ++ tail, e)
  }

  def removeAt3[A](n: Int, list: List[A]): (List[A], A) =
    if (n < 0) throw new NoSuchElementException
    else (n, list) match {
      case (_, Nil) => throw new NoSuchElementException
      case (0, head :: tail) => (tail, head)
      case (_, head :: tail) => {
        val (t, e) = removeAt3(n - 1, list.tail)
        (head :: t, e)
      }
    }

}