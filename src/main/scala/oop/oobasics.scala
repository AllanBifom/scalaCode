package oop

object oobasics extends App{

  val person = new Person("Allan", 100)
  println(person.x)
  person.greet("john")
  // Testing for functions bellow
  println("****************************************************************************************")
  val author = new Writer("Allan","Bifom",1912)
  val imposter = new Writer("Allan","Bifom",1912)
  val novel = new Novel("Your lie in April",1940,author)
  println(novel.isWrittenBy(imposter))
println("******************************************************************************************")
  val counter = new Counter()
  counter.increment.print
  counter.increment.increment.increment.print
  counter.increment(10).print
 // val counter = new Counter(1) .. This will also work even though I set a default value for the counter class

}
// Constructor
// Class parameters are not fields
// to convert to field you have to add the val keyword before the parameter as seen in age
class Person(name: String, val age: Int){
  val x = 2; // fields
  //println(1+3)
  def greet (name: String): Unit = println(s"Hi ${this.name}, I am $name")
  // this.name is used because the name in the greet function parameter will override the class name if it is not used

  // Overloading: Means defining methods with the same name but different signatures
  // multiple Constructors
  def this(name: String) = this(name,0)
  def this() = this("john doe")


}
/*
  Novel and writer
  writer: first name, surname and year of birth
   - method fullname
  Novel: Name , year of release and author(an instance of type writer)
    authorage: returns age of author at year of release
    isWritenBy: boolean to check if its written by author
    Copy(new year of release) = new instance of the novel
   */
/*
counter class
- receives an int value
- method current count
-method to increment/ decrement => new Counter
- overload inc/dec to receive an amount
 */
class Writer(firstName: String, surName: String, val yob:Int){
  def fullName() = firstName + "" + surName

}
class Novel(Name: String, YOR: Int, author: Writer){
  def authorAge()= YOR - author.yob
  def isWrittenBy(author: Writer) =   author == this.author
  def copy(year: Int) = new Novel(Name,year,author)
}
class Counter(val value: Int = 0){
  def currentCount = value

  def increment = {
    println("Incrementing")
    new Counter(value+1)}
  def decrement = {
    println("decrementing")
    new Counter(value-1)
  }

  // overload
  def increment(n: Int): Counter ={
    if(n <= 0) this
    else increment.increment(n-1)
  }
  def decrement(n: Int): Counter = {
    if (n <= 0) this
    else decrement.decrement(n-1)
  }
  def print = println(value)


}

