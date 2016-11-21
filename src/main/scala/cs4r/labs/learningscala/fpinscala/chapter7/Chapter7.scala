package cs4r.labs.learningscala.fpinscala.chapter7


import java.util.concurrent._
import language.implicitConversions

object Par {
  type Par[A] = ExecutorService => Future[A]


  def unit[A](a: A): Par[A] = ???
  def map2[A,B,C](a: Par[A], b: Par[B])(f: (A,B) => C): Par[C] = ???
  def fork[A](a: => Par[A]): Par[A] = ???
  def lazyUnit[A](a: => A): Par[A] = fork(unit(a))
  def run[A](a: Par[A]): A = ???


}

