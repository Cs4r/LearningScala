package cs4r.labs.learningscala.ninetynineproblems

/**
  * Find the last element of a list.
  */
object Problem1 {

  def last[T](list: List[T]): T = list match {
    case x :: Nil => x
    case x :: tail => last(tail)
    case Nil => throw new NoSuchElementException
  }

}