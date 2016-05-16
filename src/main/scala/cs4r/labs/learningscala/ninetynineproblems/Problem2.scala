package cs4r.labs.learningscala.ninetynineproblems

/**
  * Find the last but one element of a list
  */
object Problem2 {

  def penultimate[T](list: List[T]): T = list match {
    case x :: _ :: Nil => x
    case _ :: tail => penultimate(tail)
    case _ => throw new NoSuchElementException
  }
}
