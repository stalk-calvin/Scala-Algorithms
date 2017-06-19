package Coursera.Week3

/**
  * Created by calee on 5/10/17.
  */
// Persistent data structure - when we do changes, old version is still maintained
class BSTNonEmpty(elem:Int, left:IntSet, right:IntSet) extends IntSet {
  def contains(x:Int): Boolean = {
    if (x<elem) left contains x
    else if (x>elem) right contains x
    else true
  }

  def incl(x:Int): IntSet = {
    if (x<elem) new BSTNonEmpty(elem, left incl x, right)
    else if (x>elem) new BSTNonEmpty(elem, left, right incl x)
    else this
  }

  def union(other: IntSet): IntSet = {
    ((left union right) union other) incl elem
  }
  override def toString: String = "{" +left + elem + right + "}"
}
