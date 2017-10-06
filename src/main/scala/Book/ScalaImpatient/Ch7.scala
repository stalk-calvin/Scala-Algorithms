package com {
    package horstmann {
        package impatient {
            class Manager {
                val subordinates = new scala.collection.mutable.ArrayBuffer[String]
                subordinates.append("Calvin")
                subordinates.append(com.horstmann.collection.test.a)
            }
        }
        package collection {
            object test {
                var a = "test"
            }
        }
    }
}

package object random {
    private var n = 1
    def nextInt:Int = {
        n = (n * 1664525 + 1013904223) % math.pow(2, 32).toInt
        n
    }
    def nextDouble:Double = {
        nextInt
    }
    def getSeed: Double = n
    def setSeed(seed: Int): Unit = {n = seed}
}

import java.util.{HashMap => JavaMap}

import scala.collection.mutable.{HashMap => ScalaMap}

object Hashmaps extends App {
    val jMap = new JavaMap[String, String]
    jMap.put("1", "One")
    jMap.put("2", "Two")
    jMap.put("3", "Three")

    val sMap = new ScalaMap[String, String]

    val entryIter = jMap.entrySet().iterator()
    while (entryIter.hasNext()) {
        val entry = entryIter.next()
        sMap += ((entry.getKey(), entry.getValue()))
    }

    for((k,v) <- sMap) {
       assert(jMap.containsKey(k))
       assert(jMap.containsValue(v))
    }
}

object Greeting extends App {
    val username = System.getProperty("user.name")
    print("Password for " + username + ": ");
    val password = Console.readLine
    if(password.equals("secret")) System.out.println("Hello " + username)
    else System.err.println("Invalid password")
}

object testApp extends App {
    val test = new com.horstmann.impatient.Manager
    for(x <- test.subordinates) {
        println(x)
    }

    assert(1015568748 == random.nextInt)
    assert(1.586005467E9 == random.nextDouble)
}
