package cs4r.labs.learningscala.fpinscala.chapter6

trait RNG {
  def nextInt: (Int, RNG)
}

object RNG {

  case class SimpleRNG(seed: Long) extends RNG {
    def nextInt: (Int, RNG) = {
      val newSeed = (seed * 0x5DEECE66DL + 0xBL) & 0xFFFFFFFFFFFFL
      val nextRNG = SimpleRNG(newSeed)
      val n = (newSeed >>> 16).toInt
      (n, nextRNG)
    }
  }

  def nonNegative(rng: RNG): (Int, RNG) = {
    val (nextInt, newRng) = rng.nextInt
    (if (nextInt < 0) -(nextInt + 1) else nextInt, newRng)
  }

  def double(rng: RNG): (Double, RNG) = {
    val (int, random)  = nonNegative(rng)
    (int/(Integer.MAX_VALUE.toDouble+1), random)
  }

  def intDouble(rng: RNG): ((Int, Double), RNG) = {
    val (i, r1) = rng.nextInt
    val (d, r2) = double(r1)
    ((i, d), r2)
  }

  def doubleInt(rng: RNG): ((Double, Int), RNG) = {
    val ((i, d), r) = intDouble(rng)
    ((d, i), r)
  }

  def double3(rng: RNG): ((Double, Double, Double), RNG) = {
    val (d1, r1) = double(rng)
    val (d2, r2) = double(r1)
    val (d3, r3) = double(r2)
    ((d1, d2, d3), r3)
  }

  def ints(count: Int) (rng: RNG) : (List[Int], RNG) = {
    if(count == 0) {
      (List(), rng)
    }else{
      val (h, r1) = rng.nextInt
      val (t, r2) = ints(count-1)(r1)
      (h::t, r2)
    }
  }


  type Rand[A] = State[RNG, A]

  val int: Rand[Int] = _.nextInt

  def unit[A](a: A): Rand[A] =
    rng => (a, rng)


  def map[A, B](s: Rand[A])(f: A => B):Rand[B] = rng => {
   val (a, rng2) = s(rng)
    (f(a), rng2)
  }

  def nonNegativeEven:Rand[Int] = map(nonNegative)(i => i - i%2)

  def double2: Rand[Double] = map(nonNegative)(_/(Integer.MAX_VALUE.toDouble+1))

  def map2[A,B,C](ra: Rand[A], rb: Rand[B])(f: (A, B) => C): Rand[C] = rng => {
    val (a, rng2) = ra(rng)
    val (b, rng3) = rb(rng2)
    (f(a,b), rng3)
  }

  def both[A,B](ra: Rand[A], rb: Rand[B]): Rand[(A,B)] =
    map2(ra, rb)((_, _))

  val randIntDouble: Rand[(Int, Double)] =
    both(int, double)

  val randDoubleInt: Rand[(Double, Int)] =
    both(double, int)


  def flatMap[A,B](f: Rand[A])(g: A => Rand[B]): Rand[B] = {

    rng => {
      val (a, r1) = f(rng)
      g(a)(rng)
    }
  }

  type State[S,+A] = S => (A,S)



}
