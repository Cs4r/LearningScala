package cs4r.labs.learningscala.otherexercises

import scala.annotation.implicitNotFound;


object ImplicitConversions extends App {

  import cs4r.labs.learningscala.otherexercises.implicits._

  println("Juan".sayHello)
}


case class Complex(re: Double, im: Double) {
  def +(that: Complex): Complex = Complex(re + that.re, im + that.im)

  def -(that: Complex): Complex = Complex(this.re - that.re, this.im - that.im)

  override def toString = s"$re + ${im}i"
}


object Implicits extends App {

  case class Multiplier(value: Long) extends AnyVal

  implicit val defaultMultiplier = Multiplier(2)

  def multiply(a: Long)(implicit b: Multiplier): Long = a * b.value

  println(multiply(2))

  @implicitNotFound("Cannot find implicit of type ToCube in scope")
  class ToCube(val value: Long) extends AnyVal

  implicit val toCube = new ToCube(3)

  def cube(implicit toCube: ToCube): Long = toCube.value * toCube.value * toCube.value

  println(cube)


  implicit class IntToEuros(val int: Int) extends AnyVal {
    @inline def euros: String = int + "€"
  }

  println(s"I have ${5.euros}")

  implicit class ComplexSquareRoot(val complex: Complex) {

    @inline def abs: Double = math.sqrt(complex.re) + math.sqrt(complex.im)
  }

  println(Complex(4,4).abs)

}


