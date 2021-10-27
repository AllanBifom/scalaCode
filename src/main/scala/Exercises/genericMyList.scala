package Exercises

import scala.language.postfixOps

/**
 * Generic class for My list
 *
 * @tparam A
 */
abstract class genericMyList[+A] {
  /*
 singly linked list that holds integers
 head = first element of the list
 tail = the remainder of the list
 isEmpty
 add(int) => new list with this element added
 toString
  */

  def head :A
  def tail: genericMyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): genericMyList[B]
  // Implementing tostring method
  def printElements:String
  override def toString: String = "[" + printElements + "]"

  def map[B](transformer: A => B): genericMyList[B]
  def flatMap[B](transformer: A => genericMyList[B]): genericMyList[B]
  def filter(predicate: A => Boolean):genericMyList[A]
  // concatenation
  def ++[B >: A](list: genericMyList[B]): genericMyList[B]

  //HOFS
  def foreach(f: A => Unit): Unit

  def sort(compare:(A,A) => Int): genericMyList[A]

  def zipWith[B,C](list: genericMyList[B], Zip:(A,B) => C): genericMyList[C]

  def fold[B](start: B)(operator: (B,A) => B): B


}
// ??? returns nothing
object Empty extends genericMyList[Nothing] {
  def head :Nothing = throw new NoSuchElementException
  def tail: genericMyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element:B): genericMyList[B] = new Cons(element, Empty)
  def printElements:String = ""
  /*
  [1,2,3].map(n*2)
  = new Cons(2,[2,3].map(n*2))
  = new Cons(2,new Cons(4,[3].map(n*2)))
  = new cons(2,new Cons(4,new Cons(6, Empty.map(n*2))))
  = new cons(2,new Cons(4,new Cons(6, Empty)))
   */
  def map[B](transformer: Nothing => B): genericMyList[B] = Empty
  def flatMap[B](transformer: Nothing => genericMyList[B]): genericMyList[B] = Empty
  def filter(predicate: Nothing => Boolean):genericMyList[Nothing] = Empty
  def ++[B >: Nothing](list: genericMyList[B]): genericMyList[B] = list

  // HOFS
  def foreach(f: Nothing => Unit): Unit = ()

  def sort(compare:(Nothing,Nothing) => Int): Empty.type = Empty

  def zipWith[B,C](list: genericMyList[B], Zip:(Nothing,B) => C): Empty.type ={
    if(!list.isEmpty) throw new RuntimeException("List are not equal")
    else Empty
  }
  def fold[B](start:B)(operator: (B, Nothing) => B): B = start


}
class Cons[+A](h: A, t:genericMyList[A])extends genericMyList[A] {
  def head :A = h
  def tail: genericMyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element:B): genericMyList[B] = new Cons(element, this)
  def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements

  /*
  [1,2,3].filter(n % 2 == 0)
  = [2,3].filter(n % 2 == 0)
  = new Cons(2, [3].filter(n % 2 == 0))
  = new cons(2,Empty.filter(n % 2 == 0))
  = new Cons(2,Empty)
   */
  def filter(predicate: A => Boolean): genericMyList[A] = {
    if(predicate(h)) new Cons(h,t.filter(predicate)) // predicate.apply
    else t.filter(predicate)
  }
  def map[B](transformer: A => B): genericMyList[B] =
    new Cons(transformer(h),t.map(transformer)) //transformer.apply

  /*
  [1,2] ++ [3,4,5]
  = new Cons(1, [2]++[3,4,5])
  = new Cons(1, new Cons(2, Empty ++ [3,4,5]))
  = new Cons(1, new Cons(2,new Cons(3,new Cons(4,new Cons(5))))
   */
  def ++[B >: A](list: genericMyList[B]): genericMyList[B] = new Cons(h, t ++ list)

  /*
  [1,2].flatmap(n => [n, n+1])
  = [1,2] ++ [2].flatmap(n => [n, n+1])
  = [1,2] ++ [2,3] ++ Empty.flatmap(n => [n,n+1])
  = [1,2] ++ [2,3] ++ Empty
  = [1,2,2,3]
   */
  def flatMap[B](transformer: A => genericMyList[B]): genericMyList[B] =
    transformer.apply(h) ++ t.flatMap(transformer)

  //HOFS
  def foreach(f: A => Unit): Unit = {
    f(h)
    t.foreach(f)
  }

  def sort(compare:(A,A) => Int): genericMyList[A] ={
    def insert(x: A, sortedList: genericMyList[A]): genericMyList[A]={
      if (sortedList.isEmpty) new Cons(x,Empty)
      else if (compare(x, sortedList.head) <= 0) new Cons(x, sortedList)
      else new Cons(sortedList.head, insert(x, sortedList.tail))
    }
    val sortedTail = t.sort(compare)
    insert(h,sortedTail)
  }

  def zipWith[B,C](list: genericMyList[B], Zip:(A,B) => C): genericMyList[C] ={
    if(list.isEmpty) throw new RuntimeException("List are not equal")
    else new Cons(Zip(h, list.head), t.zipWith(list.tail,Zip))
  }
  def fold[B](start: B)(operator: (B,A) => B): B ={
    val newStart = operator(start, h)
    t.fold(newStart)(operator)
  }



}

// Higher order functions either receive other functions as parameters or return other functions as results

object ListTester extends App{
  val listOfIntegers: genericMyList[Int] = new Cons(1,new Cons(2, new Cons(3,Empty)))
  val listOfStrings: genericMyList[String] = new Cons("Scala",new Cons("is",new Cons("fun",Empty)))
  println(listOfStrings,listOfIntegers)

  println(listOfIntegers.map(i => i * 2).toString) // we could use under score and remove the i = map(_*2)
  println(listOfIntegers.filter(i => i%2 == 0))
  println(listOfIntegers.flatMap(elem => new Cons(elem,new Cons(elem+1,Empty))).toString)

  listOfIntegers.foreach(println)
  println(listOfIntegers.sort((x,y)=> y-x))
  println(listOfIntegers.zipWith[String,String](listOfStrings, _+ "-" +_))
  println(listOfIntegers.fold(0)(_+_))

  // for comprehensions
  val combinations = for {
    n <- listOfIntegers
    str <- listOfStrings
  } yield n + "-" + str

  println(combinations)

}
