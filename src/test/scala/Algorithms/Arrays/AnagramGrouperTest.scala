package Algorithms.Arrays

import org.scalatest.FunSuite
import scala.collection.mutable.ArrayBuffer

class AnagramGrouperTest extends FunSuite {

    val fixture: AnagramGrouper = new AnagramGrouper

    test("testAnagramGrouper") {
        val strings = Array[String]("eat", "tea", "tan", "ate", "atn", "bat")
        val actual = fixture.anagramGrouper(strings)

        val expected = new ArrayBuffer[ArrayBuffer[String]]
        expected.append(ArrayBuffer[String]("ate", "eat", "tea"))
        expected.append(ArrayBuffer[String]("atn", "tan"))
        expected.append(ArrayBuffer[String]("bat"))
        expected equals actual
    }

}
