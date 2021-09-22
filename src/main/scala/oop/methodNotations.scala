package oop

object methodNotations extends App{
  class Person(val name: String, favouriteMovie: String){
    def likes(movie: String): Boolean = movie == favouriteMovie
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
  }

  val paiko = new Person("paiko","Inception")
  println(paiko.likes("Inception"))
  println(paiko likes "Inception") // equivalent
  // This is called infix notation or operator notation
  // It only works with methods which have only one parameter i.e object method parameter

  // "Operators" in scala
  val tim = new Person("tim","terminator")
  println(paiko + tim)
  // the plus signs are also methods
  // 1+2 == 1.+(2)


}

