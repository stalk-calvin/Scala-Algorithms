/*
 * Copyright Calvin Lee Since 2017.
 * All Rights Reserved.
 */

package Coursera.Week4

import org.scalatest._

class NumberTest extends FunSuite {

  var fixture: Number = new Number(10)
  val expectedVal: Integer = 10

  test("testLeftOp") {
    assertThrows[Error] {
      fixture.leftOp
    }
  }

  test("testNumValue") {
    assert(expectedVal == fixture.numValue)
  }

  test("testRightOp") {
    assertThrows[Error] {
      fixture.rightOp
    }
  }

  test("testIsNumber") {
    assert(fixture.isNumber)
  }

  test("testIsSum") {
    assert(!fixture.isSum)
  }

}
