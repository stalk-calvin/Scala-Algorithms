package Coursera.Week3

/**
  * Created by calee on 5/10/17.
  */
object BSTEmpty extends IntSet {
  def contains(x:Int): Boolean = false
  def incl(x:Int): IntSet = new BSTNonEmpty(x, BSTEmpty, BSTEmpty)
  def union(other:IntSet): IntSet = other
  override def toString: String = "."
}
