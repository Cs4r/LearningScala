package cs4r.labs.learningscala.ninetynineproblems

/**
  * Duplicate the elements of a list a given number of times.
  */
object Problem15 {
  
  def duplicateN[T](n: Int, list: List[T]): List[T] = {
    list flatMap (x => List.fill(n)(x))
  }

  def main(args: Array[String]) {
    println(duplicateN(3, List(1, 2, 3, 4)))
  }

}
