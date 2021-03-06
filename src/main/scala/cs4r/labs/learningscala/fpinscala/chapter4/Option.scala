package cs4r.labs.learningscala.fpinscala.chapter4


import scala.{Either => _, Option => _, Some => _}


sealed trait Option[+A] {
  def flatMap[B](f: A => Option[B]): Option[B] = this match {
    case None => None
    case Some(a) => f(a)
  }

  def map[B](f: A => B): Option[B] = this match {
    case None => None
    case Some(a) => Some(f(a))
  }

  def getOrElse[B >: A](default: => B): B = this match {
    case None => default
    case Some(a) => a
  }

  def orElse[B >: A](ob: => Option[B]): Option[B] = this match {
    case None => ob
    case _ => this
  }

  def filter(f: A => Boolean): Option[A] = this match {
    case Some(a) if f(a) => this
    case _ => None
  }
}

case class Some[+A](get: A) extends Option[A]

case object None extends Option[Nothing]


object Option {

  def variance(xs: Seq[Double]): Option[Double] = {
    (mean(xs) flatMap (m => mean(xs.map(x => math.pow(x - m, 2)))))
  }


  def mean(xs: Seq[Double]): Option[Double] =
    if (xs.isEmpty) None
    else Some(xs.sum / xs.length)


  def map2[A, B, C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] = {
    a flatMap (a1 => b map (b1 => f(a1, b1)))
  }

  def sequence[A](a: List[Option[A]]): Option[List[A]] = a match {
    case head :: tail => head flatMap (hh => sequence(tail) map (tt => (hh :: tt)))
  }

  def traverse[A, B](a: List[A])(f: A => Option[B]): Option[List[B]] =  ???

  sealed trait Either[+E, -A]
  case class Left[+E](value: E) extends Either[E, Nothing]
  case class Right[+A](value: A) extends Either[Nothing, A]

}