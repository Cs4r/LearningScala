package cs4r.labs.learningscala.ninetynineproblems

import org.scalatest._

class Problem1Test extends FlatSpec {

  behavior of "last"

  it should "throw NoSuchElementException when an empty list is provided" in {
    intercept[NoSuchElementException] {
      Problem1.last(Nil)
    }
  }

  it should "return first element when a list of one element is provided" in {
    assert(Problem1.last(List(1)) == 1)
  }

  it should "return last element when a list whose size is greater than 1 is provided " in {
    assert(Problem1.last(List(1, 2, 3, 4)) == 4)
  }
}
