package Exercises

abstract class MyList {
  /*
  singly linked list that holds integers
  head = first element of the list
  tail = the remainder of the list
  isEmpty
  add(int) => new list with this element added
  toString
   */

  def head :Int
  def tail: MyList
  def isEmpty: Boolean
  def add(element: Int): MyList
  // Implementing tostring method
  def printElements:String
  override def toString: String = "[" + printElements + "]"


}
// ??? returns nothing
case object EmptyList extends MyList {
  def head :Int = throw new NoSuchElementException
  def tail: MyList = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add(element:Int): MyList = new cons(element, EmptyList)
  def printElements:String = ""

}
case class cons(h:Int, t:MyList)extends MyList{
  def head :Int = h
  def tail: MyList = t
  def isEmpty: Boolean = false
  def add(element:Int): MyList = new cons(element, this)
  def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
}

object ListTest extends App{
  val list = new cons(1,new cons(2, new cons(3,EmptyList)))
  println(list.tail.head)
  println(list.add(4).head)
  println(list.toString)
}