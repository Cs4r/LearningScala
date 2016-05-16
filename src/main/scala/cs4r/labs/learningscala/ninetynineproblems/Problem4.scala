package cs4r.labs.learningscala.ninetynineproblems

import scala.annotation.tailrec

/**
  * Reverse a list.
  */
object Problem4 {


  def length[T](list: List[T]): Int = {

    @tailrec
    def lengthTailRec[T](n: Int, ls: List[T]): Int = ls match {

      case Nil => n
      case _ :: tail => lengthTailRec(n + 1, tail)

    }

    lengthTailRec(0, list)

  }
}
