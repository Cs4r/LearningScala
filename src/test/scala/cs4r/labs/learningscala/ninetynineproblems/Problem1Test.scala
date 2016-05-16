package cs4r.labs.learningscala.ninetynineproblems

import org.scalatest._

class Problem1Test extends FlatSpec {

  "last" should "throw IllegalArgumentException when an empty list is provided" in {
    intercept[IllegalArgumentException] {
      Problem1.last(Nil)
    }
  }

  "last" should "return first element when a list of one element is provided" in {
    assert(Problem1.last(List(1)) == 1)
  }

  "last" should "return last element when a list whose size is greater than 1 is provided " in {
    assert(Problem1.last(List(1, 2, 3, 4)) == 4)
  }
}
