package cs4r.labs.learningscala.otherexercises

import scala.annotation.implicitNotFound;


object ImplicitConversions extends App {

  import cs4r.labs.learningscala.otherexercises.implicits._

  println("Juan".sayHello)
}

/**
  * Created by cs4r on 28/01/17.
  */
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


}


