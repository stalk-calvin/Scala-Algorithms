package Coursera.Week3

/**
  * Created by calee on 5/10/17.
  */
abstract class IntSet {
  def incl(x:Int): IntSet
  def contains(x:Int): Boolean
  def union(other:IntSet): IntSet
}
