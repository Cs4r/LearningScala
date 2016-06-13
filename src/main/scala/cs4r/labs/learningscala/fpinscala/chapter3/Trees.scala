package cs4r.labs.learningscala.fpinscala.chapter3



object Trees extends App{

  sealed trait Tree[+A]

  case class Leaf[A](value: A) extends Tree[A]

  case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

  def size[A](tree: Tree[A]) : Int = tree match {
    case Leaf(_) => 1
    case Branch(l, r) => 1 + size(l) + size(r)
  }


  def maximum(tree: Tree[Int]) : Int = tree match {
    case Leaf(v) => v
    case Branch(l, r) => maximum(l) max maximum(r)
  }

  def depth[A](tree: Tree[A]) : Int = tree match {
    case Leaf(_) => 0
    case Branch(l, r) => 1 + (depth(l) max depth(r))
  }

  def map[A, B](tree: Tree[A])(f: A => B): Tree[B] = tree match {
    case Leaf(v) => Leaf(f(v))
    case Branch(l, r) => Branch(map(l)(f), map(r)(f))
  }

  def fold[A,B](tree: Tree[A])(f: A => B)(g: (B,B) => B): B = tree match {
      case Leaf(v) => f(v)
      case Branch(l, r) => g(fold(l)(f)(g), fold(r)(f)(g))
  }

  def sizeByFold[Int](t: Tree[Int]): Int = {
    fold(t)(a => 1)(1 + _ + _ )
  }

  def maxByFold(t: Tree[Int]): Int = {
    fold(t)(a => a)(_ max _)
  }

  def depthByFold[A](t: Tree[A]): Int = {
    fold(t)(a => 0)((a,b) => 1 + (a max b))
  }

  def mapByFold[A,B](t: Tree[A])(f: A => B): Tree[B] =
    fold(t)(a => Leaf(f(a)): Tree[B])(Branch(_,_))

  val tree = Branch(Leaf(1), Branch(Leaf(2), Branch(Leaf(3), Leaf(4))))

  println("size")
  println(size(tree))

  println("maximum")
  println(maximum(tree))

  println("depth")
  println(depth(tree))

  println("map")
  println(map(tree)(_*2))
}
