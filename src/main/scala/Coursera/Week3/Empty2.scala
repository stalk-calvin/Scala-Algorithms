package Coursera.Week3

/**
  * Created by calee on 5/10/17.
  */
//Empty implemented as a singleton (singletons gets created when you first define it)
//We should really be making Empty a singleton because there's only one Empty
object Empty2 extends IntSet {
  def contains(x: Int): Boolean = false

  //Singletons don't need the "new" to instantiate. Empty2 is already a value
  def incl(x: Int): IntSet = new NonEmpty(x, Empty2, Empty2)

  override def toString = "."
  def union(other: IntSet): IntSet = other
}
