package cs4r.labs.learningscala.fpinscala.chapter2

/**
  * Created by cs4r on 4/06/16.
  */
object Exercises extends App {


  println(fib(23))

  private val ints: Array[Int] = Array(1, 2, 3, 4, 4)

  println(isSorted(ints, (a: Int, b: Int) => a < b))
  println(isSorted(ints, (a: Int, b: Int) => a <= b))
  println(isSorted(ints.reverse, (a: Int, b: Int) => a > b))
  println(isSorted(ints.reverse, (a: Int, b: Int) => a >= b))


  def curry[A, B, C](f: (A, B) => C): A => (B => C) = {

    val g: A => B => C = (a: A) => (b: B) => f(a, b)

    g
  }

  def uncurry[A, B, C](f: A => B => C): (A, B) => C = {
    val g: (A, B) => C = (a: A, b: B) => f(a)(b)

    g
  }


  def compose[A, B, C](f: B => C, g: A => B): A => C = {
    val h: A => C = (a: A) => f(g(a))
    h
  }


  def fib(n: Int): Int = {

    def fibTailRecursive(n: Int, prev: Int, next: Int): Int = n match {
      case 0 => prev
      case _ => fibTailRecursive(n - 1, next, prev + next)
    }

    return fibTailRecursive(n, 0, 1)
  }

  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {


    def loop(n: Int): Boolean = {
      if (n == as.length)
        true
      else if (ordered(as(n - 1), as(n)))
        loop(n + 1)
      else false
    }

    if (as.length < 2)
      true
    else
      loop(1)
  }
}
