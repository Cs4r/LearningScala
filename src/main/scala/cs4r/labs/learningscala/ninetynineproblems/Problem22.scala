package cs4r.labs.learningscala.ninetynineproblems

import scala.annotation.tailrec

/**
  * Create a list containing all integers within a given range.
  */
object Problem22 {

  def main(args: Array[String]) {
    println(range1(1, 20))
    println(range2(1, 20))
    println(range3(1, 20))
    println(range4(1, 20))
  }

  def range4(start: Int, end: Int): List[Int] = {
    @tailrec
    def rangeTailRecursive(end: Int, result: List[Int]): List[Int] = {
      if (start > end) result
      else rangeTailRecursive(end - 1, end :: result)
    }
    rangeTailRecursive(end, Nil)
  }

  def range3(a: Int, b: Int): List[Int] = {
    if (b >= a) range3(a,b-1) :+ b
    else List()
  }

  def range2(a: Int, b: Int): List[Int] = {
    if (a > b) List()
    else a +: range2(a + 1, b)
  }

  def range1(a: Int, b: Int): List[Int] = {
    a to b toList
  }
}
