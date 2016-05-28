package cs4r.labs.learningscala.ninetynineproblems

import scala.annotation.tailrec
import scala.util.Random

/**
  * Lotto: Draw N different random numbers from the set 1..M.
  */
object Problem24 {

  def main(args: Array[String]) {
    println(lotto1(6, 49))
    println(lotto2(6, 49))
  }

  def lotto2(a: Int, b: Int): List[Int] = {

    @tailrec
    def lottoTailRecursive(a: Int, b: Int, list: List[Int], random: Random): List[Int] = {
      if (a > 0)
        lottoTailRecursive(a - 1, b, list :+ random.nextInt(b), random)
      else list
    }

    lottoTailRecursive(a, b, Nil, new Random(33))
  }

  def lotto1(a: Int, b: Int): List[Int] = {
    val random = new Random(33)
    for (i <- 0 until a toList) yield random.nextInt(b)
  }
}
