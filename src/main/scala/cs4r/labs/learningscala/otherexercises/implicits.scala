package cs4r.labs.learningscala.otherexercises


/**
  * Created by cs4r on 28/01/17.
  */
package object implicits {

  class Greeter(s: String) {
    def sayHello: String = "hola " + s + "!"
  }

  implicit def stringToGreeter(s: String) = new Greeter(s)
}
