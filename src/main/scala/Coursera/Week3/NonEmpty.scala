package Coursera.Week3

/**
  * Created by calee on 5/10/17.
  */
class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def contains(x: Int): Boolean = {
    if(x < elem) left.contains(x)
    else if (x > elem) right.contains(x)
    else true
  }
  //creates persistent data structure. If we make changes to the datastructure,
  //we maintain the old copy of the datastructure and make a copy with the changes we want
  def incl(x: Int): IntSet =  {
    if(x < elem) new NonEmpty(elem, left.incl(x), right)
    else if(x > elem) new NonEmpty(elem, left, right.incl(x))
    else this
  }
  override def toString = "{"+left+elem+right+"}"

  //combine this IntSet with the other IntSet. Do not repeat elements

  def union(other: IntSet):IntSet = {
    ((left union right) union other) incl elem
  }
}
