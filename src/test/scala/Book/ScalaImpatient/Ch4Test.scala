/*
 * Copyright Calvin Lee Since 2017.
 * All Rights Reserved.
 */

package Book.ScalaImpatient

import org.scalatest.FunSuite

import scala.collection.immutable.{ListMap, SortedMap}
import scala.collection.mutable

class Ch4Test extends FunSuite {
    val fixture:Ch4 = new Ch4

    test("testGizmosPrice") {
        val gizmos = Map("g1" -> 1.0, "g2" -> 2.0, "g3" -> 3.0)
        assert(Map("g1" -> 0.9, "g2" -> 1.8, "g3" -> 2.7) equals fixture.setupPrices(gizmos))
    }

    test("testFileRead") {
        val f = new java.io.File(getClass.getResource("/ch4_ex2_file.txt").getPath)
        val expected = Map("ffff" -> 1, "b" -> 3, "d" -> 1, "a" -> 2, "c" -> 2, "eee" -> 1, "dd" -> 1)
        val actual = fixture.readFile(f)
        assert(actual.isInstanceOf[mutable.HashMap[String, Int]])
        assert(expected equals actual)
    }

    test("testFileReadImmutable") {
        val f = new java.io.File(getClass.getResource("/ch4_ex2_file.txt").getPath)
        val expected = Map("ffff" -> 1, "b" -> 3, "d" -> 1, "a" -> 2, "c" -> 2, "eee" -> 1, "dd" -> 1)
        val actual = fixture.readFileImmutable(f)
        assert(actual.isInstanceOf[Map[String, Int]])
        assert(expected equals actual)
    }

    test("testReadFileSorted") {
        val f = new java.io.File(getClass.getResource("/ch4_ex2_file.txt").getPath)
        var expected = ListMap("a" -> 2, "b" -> 3, "c" -> 2, "d" -> 1, "dd" -> 1, "eee" -> 1, "ffff" -> 1)
        val actual = fixture.readFileSorted(f)
        assert(actual.isInstanceOf[SortedMap[String, Int]])
        assert(expected equals actual)
        // make sure order is the same between expected vs actual
        for ((k,v) <- actual) {
            val (key, value) = expected.head
            assert(key.equals(k) && value.equals(v))
            expected -= key
        }
    }

    test("testGetMapOfWeekdays") {
        val days: mutable.Map[String, Int] = fixture.getMapOfWeekdays
        assert(days("Monday") equals java.util.Calendar.MONDAY)
    }

    test("testGetPropertiesMaxLength") {
        assert(29 == fixture.getSysPropertiesWithMaxLength)
    }

    test("testMinMax") {
        assert((1,5) equals fixture.minmax(Array(1,2,3,4,5)))
    }

    test("testTriplet") {
        assert((4,1,4) equals fixture.lteqgt(Array(1,2,3,4,5,6,7,8,9), 5))
    }
}
