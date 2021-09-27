package oop

object Inheritance extends App{

  /**
   * Animal here is a superclass of cat
   */
  // single class inheritance
  sealed class Animal{
    def eat = println("nom nom")
    val creatureType = "Wild"
  }
  /**
   * cat her is a subclass of animal
   */
  // subclasses only inherit non private methods of the super class
  // protected methods can only be used in the class it was made and its subclasses
  class cat extends Animal{
    def crunch = {
      eat
      println("crunch crunch")
    }

  }
  /*
  This means there are private, protected and public
   */

  val kitten = new cat
  kitten.crunch
  /**
   * Constructors
   */
    // This is how to extend classes with parameters
  class Person(name: String,age: Int)
  class Adult(name:String,age:Int,idCard: String)extends Person(name,age)

  // Another way to do this is if you define an auxillary constructor
  class Boy(name: String, age:Int){
    def this(name:String) = this(name,0)
  }
  class Man(name: String,age:Int,idCard:String) extends Boy(name)

  /**
   * Overriding
   */
  class Dog(override val creatureType: String) extends Animal{
    override  def eat: Unit = println("crunch crunch")
    super.eat
//    override val creatureType: String = "Domestic"
  }
  val dog = new Dog("K9")
  dog.eat

  // Type substitution (Polymorphism)
  val UnknownAnimal: Animal = new Dog("K9")
  UnknownAnimal.eat

  /**
   * SUPER: Gets the method from the primary class
   */
  /**
   * Preventing overrides
   * -Use final on member
   * -Use final on entire class
   * -Seal the class - extend classes in this file but prevent extension in other files
   */


}
