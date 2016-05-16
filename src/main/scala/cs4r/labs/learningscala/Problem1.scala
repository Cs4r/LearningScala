package cs4r.labs.learningscala

/**
  * Find the last element of a list.
  */
object Problem1 {

  def last[T](list: List[T]) : T =  list match {
    case x :: Nil => x
    case x:: tail => last(tail)
    case Nil => throw new IllegalArgumentException("Cannot find last element of an empty list");
  };

}