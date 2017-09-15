/*
 * Copyright Calvin Lee Since 2017.
 * All Rights Reserved.
 */

package Book.ScalaImpatient

import scala.beans.BeanProperty

class Ch5 {
    class Counter(private var value:Int = 0) {
        def increment() {
            if (value != Int.MaxValue) value += 1
        } // Methods are public by default
        def current(): Int = value
    }

    class BankAccount(private var balance:Int = 0) {
        def deposit(x: Int): Unit = {
            balance += x
        }
        def withdraw(x: Int): Unit = {
            balance -= x
        }
        def getBalance: Int = balance
    }

    class Time(private var hrs: Int, private var min: Int) {
        private var minutesPassed = 0
        def before(other: Time): Boolean = {
            if (other.hrs < hrs) false
            else if (other.hrs == hrs && other.min < min) false
            else true
        }
        def getMinutesPassed: Int = hrs * 24 * 60 + min
        def getHours: Int = hrs
        def getMins: Int = min
    }

    class Student {
        @BeanProperty var name:String = ""
        @BeanProperty var id:Int = 0
        //creates getters/setters
    }

    class Person(private val name:String) {
        private val fnln = name.split(' ')
        val firstName = fnln(0)
        val lastName = fnln(1)
        private var age: Int = 0
        def this(n: String, a: Int) = {
            this(n)
            if (a > 0) age = a
        }
        def description: String = name + " is " + age + " years old"
        def getAge: Int = age
    }


    class Car(val manufacturer: String, val modelName: String, val modelYear: Int = -1, var licensePlate: String = "") {
        def this(manufacturer: String, modelName: String, licensePlate: String) = {
            this(manufacturer, modelName, -1, licensePlate)
        }

        override def toString: String = {
            "[" + manufacturer + ", " + modelName + ", " + modelYear + ", '" + licensePlate + "']"
        }
    }
}

object Ch5test {
    def main(args: Array[String]) {
        val ch5 = new Ch5

        //ex 1
        val c = new ch5.Counter(Int.MaxValue)
        c.increment()
        assert(c.current == Int.MaxValue)

        //ex 2
        val ba = new ch5.BankAccount
        ba.deposit(1)
        ba.deposit(1)
        ba.deposit(1)
        ba.withdraw(1)
        assert(ba.getBalance == 2)

        //ex 3,4
        val time = new ch5.Time(2, 30)
        val otherTime = new ch5.Time(1, 10)
        assert(otherTime before time)
        assert(!(time before otherTime))

        //ex 5
        val student = new ch5.Student
        var name = "Fred"
        var id = 21212
        student.name = name
        student.id = id
        assert(student.getId == id)
        assert(student.getName equals name)
        name = "Calvin"
        id = 99999
        student.setId(id)
        student.setName(name)
        assert(student.getId == id)
        assert(student.getName equals name)

        //ex 6
        val p = new ch5.Person("Calvin Lee", -999)
        assert(p.getAge == 0)
        assert(p.firstName equals "Calvin")
        assert(p.lastName equals "Lee")

        //ex 7
        val car = new ch5.Car("Hyundai", "Sonata", 2010, "0001XY")
        assert(car.toString equals "[Hyundai, Sonata, 2010, '0001XY']")
    }
}
