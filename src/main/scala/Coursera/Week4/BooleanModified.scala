package Coursera

object True extends BooleanModified {
  def ifThenElse[T](t: => T, e: => T) = t
}

object False extends BooleanModified {
  def ifThenElse[T](t: => T, e: => T) = e
}

abstract class BooleanModified {
  //same as: if(cond) t else e
  def ifThenElse[T](t: => T, e: => T): T

  def && (x: => BooleanModified): BooleanModified = ifThenElse(x, False) //If x is true, then return x. Else, return false
  def || (x: => BooleanModified): BooleanModified = ifThenElse(True, x) //If x is true, return true. Else, return x
  def unary_! : BooleanModified = ifThenElse(False, True) //if x is true, return false. Else, return true

  def == (x: BooleanModified): BooleanModified = ifThenElse(x, x.unary_!) //if x is true, return x. Else, return the negation of x
  def != (x: BooleanModified): BooleanModified = ifThenElse(x.unary_!, x) //if x is true, return the negation of x. Else, return x

  def < (x: BooleanModified): BooleanModified = ifThenElse(False, x)
}
