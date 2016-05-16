package cs4r.labs.learningscala.ninetynineproblems

import org.scalatest.FlatSpec


class Problem2Test extends FlatSpec {
  behavior of "penultimate"

  it should "throw NoSuchElementException when an empty list is provided" in {
    intercept[NoSuchElementException] {
      Problem2.penultimate(Nil)
    }
  }

  it should "throw NoSuchElementException when a list of one element is provided" in {
    intercept[NoSuchElementException] {
      Problem2.penultimate(List(1))
    }
  }

  it should "return second element when a two-element list is provided " in {
    assert(Problem2.penultimate(List(1, 2)) == 1)
  }

  it should "return last but one element when a list whose size is greater than 2 is provided" in {
    assert(Problem2.penultimate(List(1, 2, 3, 4)) == 3)
  }
}
