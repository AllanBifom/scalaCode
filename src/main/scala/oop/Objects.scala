package oop

object Objects  {
  // SCALA DOES NOT HAVE CLASS LEVEL FUNCTION ("static")

  // To use class level definitions in scala we use objects
  object Person{ // I basically define its type, but as well its only instance
    // "static"/"class" - level functionality

    val N_eyes = 2
    def canFly = false
  }
  class Person{
    // Instance level functionality
  }
  // COMPANIONS ... The class person and the object person are companions because the reside in the same scope and
  // have the same name




  object Titan{
    // Factory method ... Because it builds Titans given some parameters.
    def from(mother: Titan, father:Titan): Titan = new Titan("Chrolo")
    // we can use an apply method for this instead
    def apply(mother: Titan, father:Titan): Titan = new Titan("rollins")

  }
  class Titan(val name: String){

  }
  def main(args: Array[String]): Unit = { // Use this or extends App To run scala apps
    println(Person.N_eyes)
    println(Person.canFly)
    // Scala Object = Singleton Instance
    val mary =  Person
    val john =  Person
    println(mary == john) //This will print true because mary and john point to the same instance i.e the object "person"
    val francis = new Person
    val brock = new Person
    println(francis==brock) // This will print false because they each point to two different instances of the class person


    val bolo = new Titan("Bolo")
    val iveticus = new Titan("Iveticus")

    val chrolo = Titan.from(bolo,iveticus)
    val rollins = Titan(bolo, iveticus) // Using the apply method

  }

  /*
  Scala Applications = Scala Objects with:
    def main(args: Array[String]): Unit
   */


}
