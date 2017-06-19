package Coursera.Week3

/**
  * Created by calee on 5/10/17.
  */
class Empty extends IntSet {
  //contains always false because an empty tree does not contain anything
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)
  override def toString = "."
  def union(other: IntSet): IntSet = other
}
