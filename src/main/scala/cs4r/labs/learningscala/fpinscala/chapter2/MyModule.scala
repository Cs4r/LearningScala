package cs4r.labs.learningscala.fpinscala.chapter2

/**
  * Created by cs4r on 4/06/16.
  */
object MyModule  extends App {


  println(fib(23))

  def fib(n: Int): Int = {

    def fibTailRecursive(n: Int, prev: Int, next: Int): Int = n match {
      case 0 => prev
      case _ => fibTailRecursive(n - 1, next, prev + next)
    }

    return fibTailRecursive(n, 0, 1)
  }
}
