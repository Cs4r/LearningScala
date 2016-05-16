package cs4r.labs.learningscala.ninetynineproblems

/**
  * Reverse a list.
  */
object Problem5 {


  def reverse[T](list: List[T]): List[T] = list match {
    case Nil => Nil
    case head :: tail => reverse(tail) :+ head
  }

  def reverseTailRecursive[T](list: List[T]): List[T] = {
    def reverse2(result: List[T], curList: List[T]): List[T] = curList match {
      case Nil => result
      case h :: tail => reverse2(h :: result, tail)
    }
    reverse2(Nil, list)
  }
}
