package cs4r.labs.learningscala.ninetynineproblems


object Problem21 {


  def main(args: Array[String]) {


    println(insertAt('new, 0, List('a, 'b, 'c, 'd)));
  }

  def insertAt[T](n: T, pos: Int, list: List[T]): List[T] = {
    val (first, second) = list.splitAt(pos);
    (first :+ n) ++ second
  }

}
