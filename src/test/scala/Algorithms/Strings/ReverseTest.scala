/*
 * Copyright Calvin Lee Since 2017.
 * All Rights Reserved.
 */

package Algorithms.Strings

import org.scalatest._

class ReverseTest extends FunSuite with BeforeAndAfter {

    var fixture: Reverse = new Reverse

    test("testReverseString3") {
        val actual = fixture.reverseString3("abcd")
        assert(actual.equals("dcba"))
    }

    test("testReverseString2") {
        val actual = fixture.reverseString2("abcd")
        assert(actual.equals("dcba"))
    }

    test("testReverseString1") {
        val actual = fixture.reverseString1("abcd")
        assert(actual.equals("dcba"))
    }

}
