package cs4r.labs.learningscala.ninetynineproblems

import org.scalatest.{FlatSpec, GivenWhenThen}


class Problem6Test extends FlatSpec with GivenWhenThen {

  behavior of "isPalindrome"

  it must "return true when Nil is provided" in {
    Given("Nil")
    When("isPalindrome is called")
    Then("the result must be true")
    assert(Problem6.isPalindrome(Nil))

  }


  it must "return true when an empty is provided" in {
    Given("an empty list")
    When("isPalindrome is called")
    Then("the result must be true")
    assert(Problem6.isPalindrome(List()))
  }

  it must "return true when a one-element list is provided" in {
    Given("a list of one element")
    When("isPalindrome is called")
    Then("the result must be true")
    assert(Problem6.isPalindrome(List(1)))
  }

  it must "return false when List(1,2) is provided" in {
    Given("the List(1,2)")
    val list = List(1, 2)
    When("isPalindrome is called")
    Then("the result must be false")
    assert(Problem6.isPalindrome(list) == false)
  }

  it must "return true when List(1,2,1) is provided" in {
    Given("the List(1,2,1)")
    val list = List(1, 2, 1)
    When("isPalindrome is called")
    Then("the result must be true")
    assert(Problem6.isPalindrome(list))
  }

  it must "return true when List(1,2,2,1) is provided" in {
    Given("the List(1,2,2,1)")
    val list = List(1, 2, 2, 1)
    When("isPalindrome is called")
    Then("the result must be true")
    assert(Problem6.isPalindrome(list))
  }

  it must "return false when List(1,2,3,1) is provided" in {
    Given("the List(1,2,3,1)")
    val list = List(1, 2, 3, 1)
    When("isPalindrome is called")
    Then("the result must be false")
    assert(Problem6.isPalindrome(list) == false)
  }


}
