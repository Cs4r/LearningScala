package cs4r.labs.learningscala.ninetynineproblems

/**
  * Find the Kth element of a list.
  */
object Problem3 {

  def nth[T](n: Int, list: List[T]): T = (n, list) match {
    case (0, x :: _) => x
    case (n, _ :: tail) => nth(n - 1, tail)
    case _ => throw new NoSuchElementException
  }
}
