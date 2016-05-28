package cs4r.labs.learningscala.ninetynineproblems

import scala.util.Random

/**
  * Generate a random permutation of the elements of a list.
  */
object Problem25 {

  def main(args: Array[String]) {
    println( randomPermute(List('a, 'b, 'c, 'd, 'e, 'f)))
  }


  def randomPermute[T](ls: List[T]): List[T] = {
    Random.shuffle(ls)
  }
}
