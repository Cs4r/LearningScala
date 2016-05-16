package cs4r.labs.learningscala.ninetynineproblems

import org.scalatest.{FlatSpec, GivenWhenThen}

/**
  * Created by cs4r on 16/05/16.
  */
class Problem3Test extends FlatSpec with GivenWhenThen {
  behavior of "nth"

  it must "return first element" in {

    Given("a list with one element")
    val list = List(1)

    When("first element is asked")
    val nth: Int = Problem3.nth(0, list)

    Then("first element is returned")
    assert(nth === 1)
  }


  it must "return second element when second element is asked" in {

    Given("a list of four elements")
    val list = List(1, 2, 3, 4)

    When("second element is asked")
    val nth: Int = Problem3.nth(1, list)

    Then("second element is returned")
    assert(nth === 2)
  }


  it must "throw NoSuchElementException when nth element is greater than number of elements" in {

    Given("a list of two elements")
    val list = List(1, 2)

    When("third element is asked")
    Then("throw NoSuchElementException")
    intercept[NoSuchElementException] {
      Problem3.nth(3, list)
    }
  }

  it must "throw NoSuchElementException when nth element is negative" in {

    Given("a list of three elements")
    val list = List(1, 2, 3)

    When("element at -2 position is asked")
    Then("throw NoSuchElementException")
    intercept[NoSuchElementException] {
      Problem3.nth(-2, list)
    }
  }

}
