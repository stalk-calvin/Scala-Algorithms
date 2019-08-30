package Book.cookbook

class Person(var firstName: String = "Calvin", private var lastName: String = "Lee",private val age: Int = 35) {
  def this(firstName: String) {
    this(firstName, "Lee")
  }
  // some class fields
  private val HOME = System.getProperty("user.home")
  // some methods
  override def toString = s"$firstName $lastName is $age years old"
  def printHome { println(s"HOME = $HOME") }
  def printFullName { println(this) }

  def fullname: String = {
    firstName + ' ' + lastName
  }
  def getLastName: String = lastName
  def setLastName(x: String)
  {
    lastName= x
  }
  var address: Option[Address] = None: Option[Address]
  def canEqual(a: Any): Boolean = a.isInstanceOf[Human]
  override def equals(that: Any): Boolean = that match {
    case that: Person => that.canEqual(this) && this.hashCode == that.hashCode
    case _ => false
  }
  override def hashCode:Int = {
    val prime = 31
    var result = 1
    result = prime * result + age
    result = prime * result + (if (fullname == null) 0 else fullname.hashCode)
    result
  }
}

case class Address(city: String, state: String, zip: String)

abstract class Pet(var name: String) {
  val greeting: Option[String]
  var age: Int
  def sayHello { println(s"My name is $name. I say ${greeting.get}, and I'm $age") }
  override def toString = s"My name is $name. I say $greeting, and I'm $age"
}
class Dog (name: String) extends Pet (name) {
  val greeting = Some("Woof")
  var age = 2
}

class OuterClass {
  class InnerClass {
    def foo(x: InnerClass): InnerClass = this
    var x = 1
  }
}

object ch4 extends App {
  val p = new Person("Calvin", "Lee")
  println(p)
  // the 'hidden' mutator method
  p.firstName_$eq("Foobar")
  println(p)

  //  Auxiliary Constructors
  val me = new Person("Auxiliary")
  println(me)

  // Default Values for Constructor Parameters
  val default_me = new Person
  println(default_me)

  // Using named parameters
  val named = new Person(firstName = "John")
  println(named)

  // Overriding Default Accessors and Mutators
  named.setLastName("Doe")
  println(named.getLastName)

  // Setting Uninitialized var Field Types
  named.address = Some(Address("Talkeetna", "AK", "99676"))
  println(named.address)
  named.address.foreach { a =>
    println(a.city)
    println(a.state)
    println(a.zip)
  }

  val dog = new Dog("Jack")
  dog.sayHello
  println(p equals named)

  val oc1 = new OuterClass
  val oc2 = new OuterClass
  val ic1 = new oc1.InnerClass
  val ic2 = new oc2.InnerClass
  ic1.x = 10
  ic2.x = 20
  println(s"ic1.x = ${ic1.x}")
  println(s"ic2.x = ${ic2.x}")
  // Cannot do below because they are distinct
  // ic1.foo(ic2)
}
