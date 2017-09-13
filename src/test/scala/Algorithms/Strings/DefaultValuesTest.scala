/*
 * Copyright Calvin Lee Since 2017.
 * All Rights Reserved.
 */

package Algorithms.Strings

import org.scalatest.FunSuite

class DefaultValuesTest extends FunSuite {

    val fixture: DefaultValues = new DefaultValues

    test("testDecorate") {
        assert(fixture.decorate("Hello").equals("[Hello]"))
    }

    test("testDecorateWithName") {
        assert(fixture.decorate(left = "<<<", str = "Hello", right = ">>>").equals("<<<Hello>>>"))
    }

    test("testDecorateMixed") {
        assert(fixture.decorate("Hello", right = "]<<<").equals("[Hello]<<<"))
    }
}
