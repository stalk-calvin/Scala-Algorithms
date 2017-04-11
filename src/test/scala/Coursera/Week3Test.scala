package Coursera

import org.scalatest.FunSuite

class Week3Test extends FunSuite {
  var bstNonEmpty: IntSet = new BSTNonEmpty(3, BSTEmpty, BSTEmpty)

  test("has bstNonEmpty") {
    assert(bstNonEmpty contains 3)
  }

  test("does not have bstNonEmpty") {
    assert(!bstNonEmpty.contains(30))
  }

  test("build BST") {
    bstNonEmpty = bstNonEmpty incl 2
    bstNonEmpty = bstNonEmpty incl 8
    bstNonEmpty = bstNonEmpty incl 3
    bstNonEmpty = bstNonEmpty incl 7
    assert("{{.2.}3{{.7.}8.}}" == bstNonEmpty.toString)
  }

  test("union") {
    bstNonEmpty = bstNonEmpty incl 2
    bstNonEmpty = bstNonEmpty incl 8
    bstNonEmpty = bstNonEmpty incl 3
    bstNonEmpty = bstNonEmpty incl 7

    val newTree = new BSTNonEmpty(1, BSTEmpty, BSTEmpty)
    val otherTree = new BSTNonEmpty(13, newTree, BSTEmpty)

    assert("{{.1{{.2{.3.}}7{.8.}}}13.}" == (bstNonEmpty union otherTree).toString)
  }
}
