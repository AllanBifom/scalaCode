package demo

object Something extends App {
  val x = 42 // variable cannot be changed... They are immutable
  var num2 = 23 // variable can be changed
  println(x)
  val astring: String = "Allan B"
  val anotherstring = "Promethues"
// variables are used as side effects
  // be mindfull of side effects
  val express = 1+2 // expression
  // >>> (right shift wit zero extension)

  val acondition = true
  val aconditionValue = if(acondition) 5 else 3 // if expression
  println(aconditionValue)
  println(if(acondition) 5 else 3 )

  // while loop PLEASE AVOID, NEVER USE
  var i = 0
  while(i < 10){
    i += 1
  }
  // EVERYTHING IN SCALA IS AN EXPRESSION
  var avariable = 1

  val aWeirdValue = (avariable = 3) // unit == void in other languages
  println(aWeirdValue)

  //side effects: println(), whiles,reassigning

  // Code blocks
  // 1.code blocks are expressions, the value of the block is the value of the last expression
  // 2.Everything defined inside the code block stays inside the code block and would not work inside
  val aCodeBlock = {
    val y = 2
    val z = y + 1
    if (z > 2) "hello" else "goodbye"
  }
}
