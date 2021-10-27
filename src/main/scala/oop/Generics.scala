package oop

object Generics extends App{

  // This also works for traits
  class myList[+A] {
    // use the type A inside the class definition
    def add[B>: A](element: B): myList[B] = ???
    /*
    A = cats
    B = dog = Animal
    B = Animal
     */
  }
  class myMap[Key, Value]
  val listOfIntegers = new myList[Int]
  val listOfStrings = new myList[String]

  /**
   * generic methods
   */
  object myList{
    def empty[A]: myList[A] = ???
  }
  val emptyListOfIntegers = myList.empty[Int]

  /**
   * Variance problem
   */
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  //1. Yes list[Cat] extends list[Animal] = COVARIANCE
  class covariantList[+A]
  val animal: Animal = new Cat
  val animalList: covariantList[Animal] = new covariantList[Cat]
  // animalList.add(new Dog) ??? Hard question => We return a list of animals

  // 2. NO =  INVARIANCE
  class InVariantList[A]
  val invariantAnimalList: InVariantList[Animal] = new InVariantList[Animal]

  // 3. Hell, no! CONTRAVARIANCE
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  /**
   * Bound types
   */
  // class cage only accepts generic type A which refers to sub classes of animals
  // upper bound <:  lower bound >:
  class Cage[A <: Animal](animal : A)
  val cage = new Cage(new Dog)

  /**
   * Expanding my list to be generic
   * // check exercise
   */

}
