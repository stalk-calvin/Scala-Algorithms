package Book.cookbook

import util.control.Breaks._
import util.control.Breaks

object ch3 extends App {
  val x = if (true) "a" else "b"
  println(x)

  val nieces = List("emily", "hannah2", "mercedes", "porsche")

  for (e <- nieces) println(e)

  for {
    item <- nieces
    digit <- item
    if digit.isDigit
  } {
    println(digit)
  }

  // uppercase the output
  nieces.foreach(e => println(e.toUpperCase))
  val newArray = for (e <- nieces) yield e.toUpperCase
  newArray.foreach(println)

  // get index
  for (i <- nieces.indices) {
    println(s"$i is ${nieces(i)}")
  }

  // similar to Python's enumerate
  for ((e, count) <- nieces.zipWithIndex) {
    println(s"$count is $e")
  }

  // looping range with condition
  for (i <- 1 to 10 if i < 4) println(i)

  // looping over map
  val names = Map("fname" -> "Robert", "lname" -> "Goren")
  for ((k,v) <- names) println(s"key: $k, value: $v")

  // looping over a multidimensional array.
  val array = Array.ofDim[Int](2,2)
  array(0)(0) = 0
  array(0)(1) = 1
  array(1)(0) = 2
  array(1)(1) = 3
  for {
    i <- 0 to 1
    j <- 0 to 1
  } println(s"($i)($j) = ${array(i)(j)}")

  //multiple if embedded in for loop
  for {
    i <- 1 to 10
    if i > 3
    if i < 6
    if i % 2 == 0
  } println(i)

  //for comprehension
  val lengths = for (e <- nieces) yield { e.length }
  lengths.foreach(println)


  // break example
  breakable {
    for (i <- 1 to 10) {
      println(i)
      if (i > 4) break // break out of the for loop
    }
  }

  // continue example
  val searchMe = "peter piper picked a peck of pickled peppers"
  var numPs = 0
  for (i <- 0 until searchMe.length) {
    breakable {
      if (searchMe.charAt(i) != 'p') {
        break // break out of the 'breakable', continue the outside loop
      } else {
        numPs += 1
      }
    }
  }
  println("Found " + numPs + " p's in the string.")

  // Nested loops and labeled breaks
  val Inner = new Breaks
  val Outer = new Breaks
  Outer.breakable {
      for (i <- 1 to 5) {
        Inner.breakable {
        for (j <- 'a' to 'e') {
          if (i == 1 && j == 'c') Inner.break else println(s"i: $i, j: $j")
          if (i == 2 && j == 'b') Outer.break
        }
      }
    }
  }

  // Matching Multiple Conditions with One Case Statement
  var i = 5
  i match {
    case 1 | 3 | 5 | 7 | 9 => println("odd")
    case 2 | 4 | 6 | 8 | 10 => println("even")
  }

  // Adding variables to patterns
  def echoWhatYouGaveMe(x: Any): String = x match {
    case List(0, _, _) => "a three-element list with 0 as the first element"
//    case List(1, _*) => "a list beginning with 1, having any number of elements"
    case Vector(1, _*) => "a vector beginning with 1 and having any number ..."
    case list @ List(1, _*) => s"Current List: $list"
    case x @ Some(_) => s"Some: $x"
  }

  val nums = List(1, 2, 3)
  println(echoWhatYouGaveMe(nums))
  println(echoWhatYouGaveMe(Some(1)))

  // case class in match
  trait Animal
  case class Dog(name: String) extends Animal
  case class Cat(name: String) extends Animal
  case object Woodpecker extends Animal

  def determineType(x: Animal): String = x match {
    case Dog(moniker) => "Got a Dog, name = " + moniker case _:Cat => "Got a Cat (ignoring the name)"
    case Woodpecker => "That was a Woodpecker"
    case _ => "That was something else"
  }

  println(determineType(new Dog("Rocky")))
  println(determineType(new Cat("Rusty the Cat")))
  println(determineType(Woodpecker))

  // Matching One or More Exceptions with try/catch
  try {
    x.toInt
  } catch {
    case e: NumberFormatException => println("Couldn't read the number.")
    case e: Exception => println("Had an Exception trying to read that file")
  }

  // user defined condition
  def whilst(testCondition: => Boolean)(codeBlock: => Unit) {
    while (testCondition) {
      codeBlock
    }
  }

  i = 0
  whilst (i < 5)
  {
    println(i)
    i += 1
  }

  def doubleif(test1: => Boolean)(test2: => Boolean)(codeBlock: => Unit) {
    if (test1 && test2) {
      codeBlock
    }
  }

  doubleif(test1 = i > 3)(test2 = numPs == 9) {
    i = 99
  }
  println(i)
}
