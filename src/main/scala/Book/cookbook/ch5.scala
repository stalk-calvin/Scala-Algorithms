package Book.cookbook

class Human {
  protected var fname = ""
  protected var lname = ""
  def setFirstName(firstName: String): this.type = {
    fname = firstName
    this
  }
  def setLastName(lastName: String): this.type = {
    lname = lastName
    this
  }
}
class Employee extends Human {
  protected var role = ""
  def setRole(role: String): this.type = {
    this.role = role
    this
  }
  override def toString = {
    "%s, %s, %s".format(fname, lname, role)
  }
}

class Pizza {
  import scala.collection.mutable.ArrayBuffer
  private val toppings = ArrayBuffer[String]()
  var crustSize = 12
  var crustType = "Thin"
  def update(crustSize: Int, crustType: String) {
    this.crustSize = crustSize
    this.crustType = crustType
  }
  def addTopping(topping: String) = {
    toppings += topping
    this
  }
  def setCrustSize(crustSize: Int) = {
    this.crustSize = crustSize
    this
  }
  def setCrustType(crustType: String) = {
    this.crustType = crustType
    this
  }
  def print() {
    println(s"crust size: $crustSize")
    println(s"crust type: $crustType")
    println(s"toppings: $toppings")
  }
  override def toString = {
    "A %d inch %s crust pizza.".format(crustSize, crustType)
  }
}

class StockInfo {
  def printAll(strings: String*) {
    strings.foreach(println)
  }

  @throws(classOf[Exception])
  def getStockInfo = {
    // other code here ...
    ("NFLX", 100.00, 101.00) // this is a Tuple3
  }
}

object ch5 extends App {
  val p = new Pizza
  p.update(crustSize = 16, crustType = "Thick")
  println(p)
  p.update(crustType = "Pan", crustSize = 14)
  println(p)
  val s = new StockInfo
  val (symbol, currentPrice, futurePrice) = s.getStockInfo
  println(symbol)
  println(currentPrice)
  println(futurePrice)
  s.printAll("foo")
  s.printAll("foo", "bar")
  s.printAll("foo", "bar", "baz")

  val fruits = List("apple", "banana", "cherry")
  s.printAll(fruits: _*)

  val employee = new Employee
  // use the fluent methods
  employee.setFirstName("Al").setLastName("Alexander").setRole("Developer")
  println(employee)

  p.setCrustSize(14)
    .setCrustType("thin")
    .addTopping("cheese")
    .addTopping("green olives")
    .print()
}
