package oop

object AbstractDataTypes extends App{
  // abstract classes cannot be initiated
  abstract class Animal{
    val creatureType: String = "wild"
    def eat: Unit
  }

  class Dog extends Animal{
    override val creatureType: String = "k9"
    def eat:Unit = println("Crunch Crunch")
  }

  // traits
  // They can be inherited among classes
  trait carnivore{
    def eat(animal: Animal): Unit
    val preferredMeal: String = "fresh meat"
  }

  trait coldBlooded
  class crocodile extends Animal with carnivore{
    override val creatureType: String = "croc"
    def eat:Unit = println("nom nom nom")
    def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating a ${animal.creatureType}")
  }
  val dog = new Dog
  val croc = new crocodile
  croc.eat(dog)

  /**
   * traits vs abstract classes
   * - traits do not have constructor parameters
   * - Multiple traits can be inherited by the same class
   * - traits = behaviour, abstract class =  type of things
   */

}
