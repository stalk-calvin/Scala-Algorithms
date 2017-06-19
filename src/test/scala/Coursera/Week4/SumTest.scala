/*
 * Copyright Calvin Lee Since 2017.
 * All Rights Reserved.
 */

package Coursera.Week4

import org.scalatest._

class SumTest extends FunSuite {

  var number1: Number = new Number(10)
  var number2: Number = new Number(20)
  var fixture: Sum = new Sum(number1, number2)

  test("testLeftOp") {
    assert(number1.equals(fixture.leftOp))
  }

  test("testNumValue") {
    assertThrows[Error] {
      fixture.numValue
    }
  }

  test("testRightOp") {
    assert(number2.equals(fixture.rightOp))
  }

  test("testIsNumber") {
    assert(!fixture.isNumber)
  }

  test("testIsSum") {
    assert(fixture.isSum)
  }

}
