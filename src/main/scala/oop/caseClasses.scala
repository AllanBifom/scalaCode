package oop

object caseClasses extends App{

  /*
  1. Case classes promote all parameters to fields
  2. Sensible toString .. println(instance) = println(instance.toString) // syntactic sugar
  3. equals and hashcode implemented OOTB
  4. case classes have copy methods
  5. case classes have companion objects
  6. case classes are serializable
  7. case classes have extractor patterns .. They can be used in pattern matching
   */
  case class Person(name: String, age: Int)

  // case objects have all the same attributes as case classes except for 5
  case object UnitedKingdom{
    def name: String = "Something"
  }
  /*
  Expand my list using case classes and case objects
   */

}
