package cs4r.labs.learningscala.ninetynineproblems

/**
  * Split a list into two parts.
  */
object Problem17 {

  def main(args: Array[String]) {
    println(split1(4, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    println(split2(4, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  }

  def split1[T](n: Int, list: List[T]): (List[T], List[T]) = {
    (list.take(n), list.drop(n))
  }

  def split2[A](n: Int, ls: List[A]): (List[A], List[A]) = ls.splitAt(n)

}
