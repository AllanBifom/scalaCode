package FunctionalProgramming

object AnonymousFunctions extends App {
  // anonymous function (Lambda)
  val doubler = (x:Int) => x*2
  val doubler2: Int => Int = x => x*2

  // multiple parameters (Lambda)
  val adder = (a: Int, b: Int) =>a+b
  val adder2: (Int,Int) => Int = (a: Int, b: Int) =>a+b

  // no parameters (Lambda)
  val doSomething = () => 3
  val doSomething2: () => Int = () => 3

  // careful
  println(doSomething) // function it self
  println(doSomething()) //  actual call

  // curly braces with lambda
  val stringToInt = { (str: String) =>
    str.toInt
  }
  // more syntactic sugar
  val niceIncrementer: Int => Int = _+1 // x=> x+1
  val niceAdder: (Int,Int) => Int = _ + _ // (a,b) => a+b
  //.. we most indicate type or the compiler would not know

  // exercises
  //MYList: replace all function x calls with lamda
  //rewrite the special adder as an anonymous function

  val superAdder = (x:Int) =>(y:Int) => x + y


}
