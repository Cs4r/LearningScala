package cs4r.labs.learningscala.fpinscala.chapter5


import cs4r.labs.learningscala.fpinscala.chapter5.Stream._;

trait Stream[+A] {


  def toList: List[A] = this match {
    case Empty => Nil
    case Cons(h, t) => h() :: t().toList

  }

  def take(n: Int): Stream[A] = this match {
    case Cons(h, _) if n == 1 => cons(h(), empty)
    case Cons(h, t) if n > 1 => cons(h(), t().take(n - 1))
    case _ => empty
  }


  def drop(n: Int): Stream[A] = this match {
    case Cons(_, t) if n > 0 => t().drop(n - 1)
    case _ => this
  }


  def takeWhile(p : A => Boolean) : Stream[A] = this match {
    case Cons(h, t) if p(h()) => cons(h(), t().takeWhile(p))
    case _ => empty
  }

  def foldRight[B](z: => B)(f: (A, => B) => B): B =
    this match {
      case Cons(h,t) => f(h(), t().foldRight(z)(f))
      case _ => z
    }

  def forAll(p: A => Boolean): Boolean = foldRight(false)((a,b) => p(a) && b)


  def takeWhile2(p: A => Boolean): Stream[A] = foldRight(empty[A])((h, t) =>
    if (p(h)) cons(h, t)
    else empty)
}

case object Empty extends Stream[Nothing]

case class Cons[+A](h: () => A, t: () => Stream[A]) extends Stream[A]


object Stream {
  def cons[A](hd: => A, tl: => Stream[A]): Stream[A] = {
    lazy val head = hd
    lazy val tail = tl
    Cons(() => head, () => tail)
  }

  def empty[A]: Stream[A] = Empty

  def constant[A](a: A) : Stream[A] = cons(a, constant(a))

  def from(n: Int): Stream[Int] = cons(n, from(n+1))

  def fibs = {

    def next(a: Int, b: Int): Stream[Int] =
      cons(a, next(b, a+b))

    next(0, 1)
  }


  def unfold[A, S](z: S)(f: S => Option[(A, S)]): Stream[A] =
    f(z) match {
      case Some((h,s)) => cons(h, unfold(s)(f))
      case None => empty
    }


  def fibs2 =
    unfold((0, 1)) { case (x, y) => Some((x, (y, x + y))) }

  def from2(n: Int) = unfold(n)(n => Some((n, n + 1)))

  def ones2 = unfold(1)(_ => Some((1,1)))

}


object Test extends App {

  val stream = cons(1, cons(2, cons(3, Empty)))


  println(stream.toList)

  println(stream.drop(3).toList)

  println(constant(5).take(3).toList)

  println(from(5).take(20).toList)
}

