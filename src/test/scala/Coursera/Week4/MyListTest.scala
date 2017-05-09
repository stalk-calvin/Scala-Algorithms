package Coursera.Week4

import org.scalatest.FunSuite

class MyListTest extends FunSuite {
  test("testApply MyList()") {
    var myList = MyList()
    assert("Nil".equals(myList.toString))
  }

  test("testApply MyList(1)") {
    var myList = MyList(1)
    assert("List(1)".equals(myList.toString))
  }

  test("testApply MyList(1,2)") {
    var myList = MyList(1,2)
    assert("List(1, 2)".equals(myList.toString))
  }

  test("testApply MyList(1,2,3)") {
    var myList = MyList(1,2,3)
    assert("List(1, 2, 3)".equals(myList.toString))
  }

  test("testApply MyList(1,2,3,4)") {
    var myList = MyList(1,2,3,4)
    assert("List(1, 2, 3, 4)".equals(myList.toString))
  }

}
