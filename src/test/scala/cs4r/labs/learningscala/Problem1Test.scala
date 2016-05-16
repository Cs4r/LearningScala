package cs4r.labs.learningscala
import org.scalatest._

class Problem1Test  extends FlatSpec {

  "last" should "throw IllegalArgumentException when empty list is provided" in {
    intercept[IllegalArgumentException]{
     Problem1.last(Nil)
    }
  }
}
