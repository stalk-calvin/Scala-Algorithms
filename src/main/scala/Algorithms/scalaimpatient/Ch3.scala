/*
 * Copyright Calvin Lee Since 2017.
 * All Rights Reserved.
 */

package Algorithms.scalaimpatient

import java.awt.datatransfer._

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

class Ch3 {
    // exercise 1
    def makeArray(n: Int): Array[Int] = {
        val a = Array(n)
        for (i <- a.indices) {
            a(i) = scala.util.Random.nextInt(n)
        }
        a
    }

    //exercise 2
    def swapAdjacent(a: Array[Int]): Array[Int] = {
        if (a == null) null
        for (i <- a.indices if i > 0 && (i+1) % 2 == 0) {
            val tmp = a(i - 1)
            a(i - 1) = a(i)
            a(i) = tmp
        }
        a
    }

    //exercise 3
    def swapAdjacentWithNew(a: Array[Int]): Seq[Int] = {
        if (a == null) null
        for (i <- a.indices) yield {
            if (i % 2 == 1) {
                a(i - 1)
            } else {
                if (i == a.length - 1) a(i) else a(i + 1)
            }
        }
    }

    //exercise 4
    def putPositiveFront(a: ArrayBuffer[Int]): ArrayBuffer[Int] = {
        if (a == null) null
        for (i <- a.indices.reverse) {
            if (a(i) <= 0) {
                a.append(a(i))
                a.remove(i)
            }
        }
        a
    }

    //exercise 5
    def getAverage(a: Array[Double]): Double = {
        if (a == null) null
        var sum = 0.0
        for (i <- a.indices)
            sum += a(i)
        sum / a.length
    }

    //exercise 6
    def reverseSorted(a: Array[Int]): Array[Int] = {
        if (a == null) null
        a.sortWith(_ > _)
    }

    def reverseSorted(a: ArrayBuffer[Int]): ArrayBuffer[Int] = {
        if (a == null) null
        a.sortWith(_ > _)
    }

    //exercise 7
    def removeDuplicate(a: Array[Int]): Array[Int] = {
        if (a == null) null
        a.distinct
    }

    //exercise 8
    def removeNegativeExceptFirstOne(a: ArrayBuffer[Int]): ArrayBuffer[Int] = {
        if (a == null) null
        var indexes = for (i <- a.indices if a(i) < 0) yield i
        indexes = indexes.drop(1)
        for (i <- indexes.reverse) a.remove(i)
        a
    }

    //exercise 9
    def getAvailableAmericanTimezone: Array[String] = {
        java.util.TimeZone.getAvailableIDs.filter(_.startsWith("America/")).map((s) => s.stripPrefix("America/"))
    }

    //exercise 10
    def convertJavaToScala: mutable.Buffer[String] = {
        val flavors = SystemFlavorMap.getDefaultFlavorMap.asInstanceOf[SystemFlavorMap]
        val nativesForFlavors = flavors.getNativesForFlavors(Array(DataFlavor.imageFlavor))
        collection.JavaConversions.asScalaBuffer(new java.util.LinkedList(nativesForFlavors.values()))
    }


}
