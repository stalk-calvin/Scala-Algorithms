/*
 * Copyright Calvin Lee Since 2017.
 * All Rights Reserved.
 */

package Book.ScalaImpatient

import java.io.File

import scala.collection.JavaConversions.propertiesAsScalaMap
import scala.collection.JavaConversions.mapAsScalaMap
import scala.collection.immutable.SortedMap
import scala.collection.mutable

class Ch4 {
    //ex 1
    def setupPrices(gizmos: Map[String,Double]): Map[String, Double] = {
        for((k,v) <- gizmos) yield k -> (v - (v * .10))
    }

    //ex2
    def readFile(f: File): mutable.Map[String, Int] = {
        val result: mutable.Map[String, Int] = new mutable.HashMap[String, Int]()
        if (f == null) result
        val in = new java.util.Scanner(f)
        while (in.hasNext()) {
            val line = in.next()
            val count = result.getOrElse(line, 0)
            result(line) = count + 1
        }
        result
    }

    //ex 3
    def readFileImmutable(f: File): Map[String, Int] = {
        var result = Map[String, Int]()
        if (f == null) result
        val in = new java.util.Scanner(f)
        while (in.hasNext()) {
            val line = in.next()
            val count = result.getOrElse(line, 0)
            result += (line -> (count+1))
        }
        result
    }

    //ex 4
    def readFileSorted(f: File): SortedMap[String, Int] = {
        var result = SortedMap[String, Int]()
        if (f == null) result
        val in = new java.util.Scanner(f)
        while (in.hasNext()) {
            val line = in.next()
            val count = result.getOrElse(line, 0)
            result += (line -> (count+1))
        }
        result
    }

    //ex 5
    def readFileJavaTreeMap(f: File): mutable.Map[String, Int] = {
        var result: scala.collection.mutable.Map[String, Int] = new java.util.TreeMap[String, Int]
        if (f == null) result
        val in = new java.util.Scanner(f)
        while (in.hasNext()) {
            val line = in.next()
            val count = result.getOrElse(line, 0)
            result += (line -> (count+1))
        }
        result
    }

    //ex 6
    def getMapOfWeekdays: mutable.LinkedHashMap[String, Int] = {
        val days = scala.collection.mutable.LinkedHashMap(
            "Monday" -> java.util.Calendar.MONDAY,
            "Tuesday" -> java.util.Calendar.TUESDAY,
            "Wednesday" -> java.util.Calendar.WEDNESDAY,
            "Thursday" -> java.util.Calendar.THURSDAY,
            "Friday" -> java.util.Calendar.FRIDAY,
            "Saturday" -> java.util.Calendar.SATURDAY,
            "Sunday" -> java.util.Calendar.SUNDAY
        )
        days
    }

    //ex 7
    def getSysPropertiesWithMaxLength: Int = {
        val jprops: scala.collection.Map[String, String] = System.getProperties()
        var maxKey = 0
        jprops.keys.foreach(k => maxKey = maxKey max k.length)
        maxKey
    }

    //ex 8
    def minmax(values: Array[Int]): (Int, Int) = (values.min, values.max)

    //ex 9
    def lteqgt(values:Array[Int], v: Int): (Int, Int, Int) = {
        var c1, c2, c3 = 0
        for (i <- values) {
            if (i < v) {
                c1 += 1
            } else if (i > v) {
                c3 += 1
            } else {
                c2 += 1
            }
        }
        (c1,c2,c3)
    }
}
