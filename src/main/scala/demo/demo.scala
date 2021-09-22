package demo
object demo{
  def main(args: Array[String]): Unit = {
    println("Hello world")
    val num1 = 21 + 2 // variable cannot be changed
    var num2 = 23 // variable can be changed
    println(num1 + num2)
  }
}