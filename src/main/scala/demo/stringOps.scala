package demo

object stringOps extends App {
  val str: String = "Hey I am Paiko OJ"
  println(str.charAt(2)) // returns character at index
  println(str.substring(6,8)) // prints from index 5 to 8
  println(str.split(" ").toList) // Separates the values which are spaced
  println(str.startsWith("Hey")) // returns true if it starts with Hey
  println(str.replace(" ", "_")) // replaces what i choose it to be
  println(str.toLowerCase())
  println(str.toUpperCase())
  println(str.length)

  val aNumeberString = "45"
  val aNumber = aNumeberString.toInt
  println('a'+: aNumeberString :+ 'z')// +: prepending , :+ appending
  println(str.reverse)
  println(str.take(2))

  // S-interpolator
  val name = "Allan"
  val age = 100
  // The S infront of the string is necessary
  val greeting = s"Hello I am $name and I am turning $age years old"
  val anotherGreeting = s"Hello I am $name and I am turning ${age + 1} years old"
  println(anotherGreeting)

  // f-interpolator
  val speed = 1.2f
  val myth = f"$name%s can eat $speed%2.2f burgers per minute"
  println(myth) // f interpolators are for formatted strings

  // raw - interpolator: can print characters literally
  println(raw"This is a  \n newline")
  val escaped = "This is a \n newline"
  print(raw"$escaped")


}
