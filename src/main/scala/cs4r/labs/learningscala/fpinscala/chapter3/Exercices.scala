package cs4r.labs.learningscala.fpinscala.chapter3

import java.util.NoSuchElementException

import scala.annotation.tailrec


object Exercices extends App {

  sealed trait List[+A]

  // A `List` data constructor representing the empty list
  /* Another data constructor, representing nonempty lists. Note that `tail` is another `List[A]`,
  which may be `Nil` or another `Cons`.
   */
  case class Cons[+A](head: A, tail: List[A]) extends List[A]


  // `List` data type, parameterized on a type, `A`
  case object Nil extends List[Nothing]


  object List {
    // `List` companion object. Contains functions for creating and working with lists.
    def sum(ints: List[Int]): Int = ints match {
      // A function that uses pattern matching to add up a list of integers
      case Nil => 0 // The sum of the empty list is 0.
      case Cons(x, xs) => x + sum(xs) // The sum of a list starting with `x` is `x` plus the sum of the rest of the list.
    }

    def product(ds: List[Double]): Double = ds match {
      case Nil => 1.0
      case Cons(0.0, _) => 0.0
      case Cons(x, xs) => x * product(xs)
    }

    def apply[A](as: A*): List[A] = // Variadic function syntax
      if (as.isEmpty) Nil
      else Cons(as.head, apply(as.tail: _*))

    def tail[A](l: List[A]): List[A] = l match {
      case Nil => throw new NoSuchElementException
      case Cons(_, t) => t
    }

    def setHead[A](newHead: A, l: List[A]): List[A] = l match {
      case Nil => Cons(newHead, Nil)
      case Cons(h, t) => Cons(newHead, t)
    }

    def drop[A](l: List[A], n: Int): List[A] = {
      if (n <= 0) {
        l
      } else l match {
        case Cons(_, t) => drop(t, n - 1)
      }

    }


    def dropWhile[A](l: List[A], p: A => Boolean): List[A] = l match {
      case Nil => throw new NoSuchElementException
      case Cons(h, t) if (p(h)) => dropWhile(t, p)
      case _ => l
    }

    def init[A](l: List[A]): List[A] = l match {
      case Cons(h, Nil) => Nil
      case Cons(h, t) => Cons(h, init(t))
      case Nil => Nil
    }

    def sum2(ns: List[Int]) =
      foldRight(ns, 0)((x, y) => x + y)

    def product2(ns: List[Double]) =
      foldRight(ns, 1.0)(_ * _) // `_ * _` is more concise notation for `(x,y) => x * y`; see sidebar


    def length[A](l: List[A]): Int = {
      foldRight(l, 0)((x, y) => y + 1)
    }

    def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B = // Utility functions
      as match {
        case Nil => z
        case Cons(x, xs) => f(x, foldRight(xs, z)(f))
      }

    @tailrec
    def foldLeft[A, B](as: List[A], z: B)(f: (B, A) => B): B = // Utility functions
      as match {
        case Nil => z
        case Cons(h, t) => foldLeft(t, f(z, h))(f)
      }

    def sum3(ns: List[Int]) =
      foldLeft(ns, 0)((x, y) => x + y)

    def product3(ns: List[Int]) =
      foldRight(ns, 1.0)(_ * _)

    def length2[A](l: List[A]): Int = {
      foldLeft(l, 0)((x, y) => x + 1)
    }

    def reverse[A](l: List[A]): List[A] = {
      foldLeft(l, List[A]())((acc, h) => Cons(h, acc))
    }

    def foldRight2[A, B](l: List[A], z: B)(f: (A, B) => B): B = {
      foldLeft(reverse(l), z)((b, a) => f(a, b))
    }

    def concat[A](l1: List[List[A]]): List[A] = {
      foldLeft(l1, List[A]())(append)
    }

    def append[A](l1: List[A], l2: List[A]): List[A] = {
      foldRight(l1, l2)((h, acc) => Cons(h, acc))
    }

    def add1(l: List[Int]): List[Int] = {
      addN(l, 1)
    }

    def addN(l: List[Int], n: Int): List[Int] = {
      foldRight(l, List[Int]())((h, acc) => Cons(h + n, acc))
    }

    def toString(l: List[Int]): List[String] = {
      foldRight(l, List[String]())((c, acc) => Cons(c.toString, acc))
    }
  }


  val x = List(1, 2, 3, 4, 5) match {
    case Cons(x, Cons(2, Cons(4, _))) => x
    case Nil => 42
    case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
    case Cons(h, t) => h + List.sum(t)
    case _ => 101
  }
  val l = List.apply(1, 2, 3, 4, 5, 6)

  println(x)

  println("drop")
  println(List.drop(l, 3))

  println("dropWhile")
  println(List.dropWhile(l, (a: Int) => a <= 3))

  println("init")
  println(List.init(l))

  println("foldRight")
  println(List.foldRight(l, Nil: List[Int])(Cons(_, _)))

  println("length")
  println(List.length(l))

  println("sum3")
  println(List.sum3(l))

  println("product3")
  println(List.product3(l))


  println("length2")
  println(List.length2(l))

  println("reverse")
  println(List.reverse(l))

  println("append")
  println(List.append(l, Cons(7, Nil)))

  println("add1")
  println(List.add1(l))

  println("toString")
  println(List.toString(l))

}
