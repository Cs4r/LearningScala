package cs4r.labs.learningscala.ninetynineproblems

import org.scalatest.{FlatSpec, GivenWhenThen}

/**
  * Created by cs4r on 16/05/16.
  */
class Problem4Test extends FlatSpec with GivenWhenThen {

  behavior of "length"

  it must "return 0 when an empty list is provided" in {
    Given("An empty list")
    val l = List()

    When("length is asked")
    val length: Int = Problem4.length(l)

    Then("zero is returned")
    assert(length === 0)
  }

  it must "return 1 when a list of one element list is provided" in {
    Given("A list of one element")
    val l = List(1)

    When("length is asked")
    val length: Int = Problem4.length(l)

    Then("one is returned")
    assert(length === 1)
  }

  it must "return n when a n-element list is provided" in {
    Given("A list of n elements")
    val l = List(1, 2, 3, 4, 5, 6)

    When("length is asked")
    val length: Int = Problem4.length(l)

    Then("n is returned")
    assert(length === 6)
  }

}
