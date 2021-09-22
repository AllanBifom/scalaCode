package demo

import scala.annotation.tailrec

object Functions extends App{
  def aFunction(a: String, b: Int): String = {  // YOU CAN REMOVE RETURN TYPE IN NORMAL FUNCTIONS
    a + " " + b
  }
println(aFunction("Hello",3))

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())

  // WHEN YOU NEED LOOPS IN SCALA USE RECURSION
  def aRepeatedFunction(aString: String, aInt: Int): String = { // YOU CANNOT REMOVE RETURN TYPES OF RECURSIVE FUNCTIONS
    if (aInt == 1) aString
    else aString + aRepeatedFunction(aString,aInt-1)
  }
  println(aRepeatedFunction("hello",3))

  def funtionWithSideEffects(astring: String): Unit = println(astring)

  // NESTED FUNCTIONS

  def aBigFuntion(n: Int):Int = {
    def aSmallerFunction(a: Int, b:Int): Int = a + b
    aSmallerFunction(n,n-1)
  }
   def greetingFunction(name: String, age:Int): Unit = println("Hi, my name is "+ name + " and I am "+ age + " years old" )
  def factorialFunction(n:Int):Int =
    if (n == 1) n
    else if (n <= 0) 1
    else n * factorialFunction(n-1)
  def fibonacciFunction(n: Int):Int =
    if (n <= 2) 1
    else fibonacciFunction(n-1) + fibonacciFunction(n-2)

  def isPrime(n: Int):Boolean = {
    @tailrec
    def isPrimeUntil(t: Int):Boolean =
      if (t <= 1) true
      else n%t != 0 && isPrimeUntil(t-1)
    isPrimeUntil(n/2)
  }

  greetingFunction("ALLAN",18)
  println(factorialFunction(5))
  println(fibonacciFunction(8))
  println(isPrime(8))

}
