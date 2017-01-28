package cs4r.labs.learningscala.otherexercises

/**
  * Created by cs4r on 28/01/17.
  */
object Implicits extends App {

  case class Multiplier(value: Long) extends AnyVal

  implicit val defaultMultiplier = Multiplier(2)

  def multiply(a: Long)(implicit b: Multiplier): Long = a * b.value

  println(multiply(2))

  case class ToCube(value: Long) extends AnyVal

  implicit val toCube = ToCube(3)

  def cube(implicit toCube: ToCube): Long = toCube.value * toCube.value * toCube.value

  println(cube)


}


