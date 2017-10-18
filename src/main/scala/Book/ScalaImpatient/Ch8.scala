package Book.ScalaImpatient

import scala.beans.BeanProperty

class Ch8 {

    class BankAccount(initialBalance: Double) {
        private var balance = initialBalance

        def deposit(amount: Double) = {
            balance += amount; balance
        }

        def withdraw(amount: Double) = {
            balance -= amount; balance
        }
        def getBalance() = balance
        override def toString = "Balance = %f".format(balance)
    }

    class CheckingAccount(initialBalance: Double, val comission: Double = 1.0) extends BankAccount(initialBalance) {
        override def deposit(amount: Double) = super.deposit(amount - comission)

        override def withdraw(amount: Double) = super.withdraw(amount + comission)
    }

    class SavingsAccount(
                          initialBalance: Double,
                          val interestRateYear: Double = 0.10,
                          val freeTransactions: Int = 3,
                          val comission: Double = 1.0
                        ) extends BankAccount(initialBalance) {
        var transactionsInMonth: Int = 0
        def isFreeTransaction() = transactionsInMonth <= freeTransactions
        override def deposit(amount: Double) = {
            transactionsInMonth += 1
            super.deposit(amount - (if (isFreeTransaction()) 0 else comission))

        }
        override def withdraw(amount: Double) = {
            transactionsInMonth += 1
            super.withdraw(amount + (if (isFreeTransaction()) 0 else comission))
        }
        def earnMonthlyInterest = {
            transactionsInMonth = 0 // reset # of transactions done
            super.deposit(getBalance() * interestRateYear / 12)
        }
    }

    abstract class Employee {
        val category = ""

        override def toString: String = category
    }

    trait Action {
        def walk() = println(toString)
    }

    class Person(@BeanProperty val name: String, @BeanProperty val age: Int) {
        override def toString = "%s,%d".format(name, age)
    }

    object Person {
        def apply(name: String = "", age: Int = 0) = new Person(name, age)
    }

    class Clerk(val person: Person, val rank: Int = 0) extends Employee with Action {
        override val category = "Clerk"
        override def toString = {
            "Category: %s (name: %s, age: %d, rank: %d)".format(category, person.getName, person.getAge, rank)
        }
    }

    abstract class Item {
        def description: String
        def price: Double
        override def toString =  "%s(%s: %f)".format(this.getClass.getSimpleName, description, price)
    }

    class SimpleItem(override val description:String, override val price:Double) extends Item

    class Bundle extends Item {
        private var items: List[Item] = List()
        def add(item: Item): Unit = items = item :: items
        def price: Double = items.map(_.price).sum
        def description: String = items.map(_.description).mkString(", ")
    }

    class Point(val x: Int, val y: Int) {
        override def toString = "Point(%d, %d)".format(x, y)
    }

    class LabeledPoint(val label: String, x: Int, y: Int) extends Point(x, y) {
        override def toString = { "LabeledPoint(%s, %d, %d)".format(label, x, y) }
    }

    abstract class Shape {
        def centerPoint: Point
        override def toString =  "%s(Center: %s)".format(this.getClass.getSimpleName, centerPoint.toString)
    }

    class Rect(val topLeft: Point, val bottomRight: Point) extends Shape {
        override val centerPoint = new Point((bottomRight.x + topLeft.x) / 2, (bottomRight.y + topLeft.y) / 2)
    }

    class Circle(val p: Point, val radius: Int) extends Shape {
        override val centerPoint = {
            // x^2+y^2 = r^2
            // use x to estimate y
            // y = +- sqrt(r^2 - x^2)

            val y:Int = math.sqrt(math.pow(radius,2) - math.pow(p.x,2)).toInt
            new Point(p.x, y) // note y can be +-
        }
    }

    import java.awt.Rectangle

    class Square(x : Int, y: Int, width: Int) extends Rectangle(x, y, width, width) {
        def this() = this(0, 0, 0)
        def this(width: Int) = this(0, 0, width)
        override def toString = "%s[x=%d,y=%d,width=%d,height=%d]".format(this.getClass.getSimpleName,x,y,width,width)
    }

    class P(val name: String) {
        override def toString = getClass.getName + "[name=" + name + "]"
    }

    class SecretAgent(codename: String) extends P(codename) {
        override val name = "secret" // Don't want to reveal name...
        override val toString = "secret" //... or class name
    }

    class Creature {
        def range: Int = 10
        val env: Array[Int] = new Array[Int](range)
    }

    class Ant extends Creature {
        // val: will create env length = 0 because range:Int is initialized to 0 first which sets the env array and
        // then assigns the range for the subclass. Therefore env length = 0
        // def: sets range=2 first then sets the env with the range variable evaluated to 2
        override def range = 2
    }
}

object Ch8 extends App {
    val ch8 = new Ch8

    // ex1
    val checkingAccount = new ch8.CheckingAccount(100.0, 2.0)
    checkingAccount.deposit(100)
    assert(checkingAccount.getBalance().equals(198.0))

    // ex2
    val savingsAccount = new ch8.SavingsAccount(100)
    savingsAccount.deposit(100)
    assert(savingsAccount.getBalance().equals(200.0))
    savingsAccount.deposit(100)
    assert(savingsAccount.getBalance().equals(300.0))
    savingsAccount.withdraw(100)
    assert(savingsAccount.getBalance().equals(200.0))
    savingsAccount.withdraw(100)
    assert(savingsAccount.getBalance().equals(99.0))
    savingsAccount.earnMonthlyInterest
    assert(savingsAccount.getBalance().equals(99.825))
    savingsAccount.deposit(100)
    assert(savingsAccount.getBalance().equals(199.825))

    // ex3
    val l: List[ch8.Employee with ch8.Action] = List(
        new ch8.Clerk(ch8.Person("John", 30), 1),
        new ch8.Clerk(ch8.Person("Sarah", 30), 10),
        new ch8.Clerk(ch8.Person("Calvin", 30), 100)
    )

    for (x <- l) x.walk()

    // ex4
    var items: List[ch8.Item] = List(
        new ch8.SimpleItem("iMac 21", 1500),
        new ch8.SimpleItem("iPhone 4s", 800)
    )

    val b = new ch8.Bundle
    b.add(new ch8.SimpleItem("iPad2", 500))
    b.add(new ch8.SimpleItem("MacBook Air 13", 1200))

    items = items :+ b

    items.foreach(println(_))

    // ex5
    val aPoint = new ch8.Point(1, 1)
    println(aPoint)

    val bPoint = new ch8.LabeledPoint("Some point", 20, 50)
    println(bPoint)

    // ex6
    val r = new ch8.Rect(new ch8.Point(0,0), new ch8.Point(10, 10))
    println(r)

    val c = new ch8.Circle(new ch8.Point(7, 0), 10)
    println(c)

    // ex7
    val s1 = new ch8.Square(1, 1, 3)
    println(s1)

    val s2 = new ch8.Square()
    println(s2)

    val s3 = new ch8.Square(5)
    println(s3)

    //ex9
    val ant = new ch8.Ant
    println(ant.env.length)
}
