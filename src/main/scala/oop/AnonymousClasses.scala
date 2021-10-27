package oop

object AnonymousClasses extends App{
  abstract class Animal{
    def eat: Unit
  }


  // anonymous class
  val funnyAnimal: Animal = new Animal {
  override def eat: Unit = println("HAHAHAH")
}
  /*
    class AnonymousClasses$$anon$1 extends Animal{
      override def eat: Unit = println("hahahaah")
    }
    val funnyAnimal: Animal = new AnonymousClasses$$anon$1 extends Animal
   */

  println(funnyAnimal.getClass)

  class Person(name: String){
    def sayHi: Unit = println(s"Hi my name is ${name} how can i help?")
  }
  val jim = new Person("Jim"){
    override def sayHi: Unit = println(s"Hi, my name is Jim how can i help?")
  }
  /*
  Anonymous classes work for abstract and non abstract data types
   */

}
