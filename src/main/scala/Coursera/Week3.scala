/*
 * Copyright Calvin Lee Since 2017.
 * All Rights Reserved.
 *//*
 * Copyright Calvin Lee Since 2017.
 * All Rights Reserved.
 */

package Coursera

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

object BSTEmpty extends IntSet {
  def contains(x:Int): Boolean = false
  def incl(x:Int): IntSet = new BSTNonEmpty(x, BSTEmpty, BSTEmpty)
  def union(other:IntSet): IntSet = other
  override def toString: String = "."
}

abstract class IntSet {
  def incl(x:Int): IntSet
  def contains(x:Int): Boolean
  def union(other:IntSet): IntSet
}
