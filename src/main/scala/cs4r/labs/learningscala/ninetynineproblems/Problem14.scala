package cs4r.labs.learningscala.ninetynineproblems

/**
  * Duplicate the elements of a list.
  */
object Problem14 {

  def duplicateList1[T](ls: List[T]): List[T] = ls match {
    case x :: tail => List(x, x) ++ duplicateList1(tail)
    case Nil => List()
  }

  def duplicateList2[T](ls: List[T]): List[T] = {
    ls flatMap (x => List(x, x))
  }

  def main(args: Array[String]) {
    println(duplicateList1((List(1, 2, 3, 4))))
    println(duplicateList2((List(1, 2, 3, 4))))
  }

}
