package oop
import scala.language.postfixOps

object methodNotations extends App{
  class Person(val name: String, favouriteMovie: String,val age: Int = 0){
    def likes(movie: String): Boolean = movie == favouriteMovie
    // function for infix
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    // function for prefix
    def unary_! :String = s"$name, Devil may cry"
    // function for postfix
    def isalive: Boolean = true
    def apply():String = s"Hi, my name is $name and I like $favouriteMovie"

    // Overload .. exercises.. See below
    def +(nickname:String):Person = new Person(s"${this.name} (${nickname})",this.favouriteMovie)
    def unary_+ : Person = new Person(name,favouriteMovie,age+1)
    def learns(thing: String): String = s"$name learns $thing"
    def apply(n: Int): String = s"$name watched $favouriteMovie $n times"

  }

  val paiko = new Person("paiko","Inception")
  println(paiko.likes("Inception"))
  println(paiko likes "Inception") // equivalent
  // This is called infix notation or operator notation( Syntactic sugar)
  // It only works with methods which have only one parameter i.e object method parameter

  // "Operators" in scala
  val tim = new Person("tim","terminator")
  println(paiko + tim)
  // the plus signs are also methods
  // 1+2 == 1.+(2)
  // all operators are methods

// prefix notation
  val x = -1 // equivalent to y
  val y =1.unary_-
  // unary_prefix only works with +,_,!,~

  println(!paiko) // because of the unary function defined above
  println(paiko.unary_!)

  // postfix notation
  println(paiko.isalive)
  println(paiko isalive)

  // apply function above
  println(paiko.apply())
  println(paiko()) // equivalent

  /*
  Overload the + operator that receives a string and returns a string
  paiko + "the man" => new person "paiko (the man)"

  2. add an age to the person class
  add a unary + operator => new person with the age + 1
  +mary => mary with the age incremented

  3. Add a "learns" method in the person class => "Mary learns scala"
    Add a learnscala method, calls learns method with "scala"
    use it in postfix notation

   4. overload the apply method to receive a number and return a string
   mary.apply(2) = > "mary watched "favourite movie" 2 times
   */
  // Testing solutions
  println((paiko + "The man")())
  println((+paiko).age)
  println(paiko learns "scala" )
  println(paiko(5))

}

