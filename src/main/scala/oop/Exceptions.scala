package oop


import scala.language
import scala.language.postfixOps

object Exceptions extends App{
  val x: String = null
  // x.length will crash program using null pointer exception
  /*
  OOP NOT FUNCTIONAL PROGRAMING EXCEPTION HANDING
   */

  // 1. throwing exceptions
 // val weirdValue = throw new NullPointerException
  // throwable classes extend the throwable class.
  // exceptions and errors are the major throwable subtypes

  // 2. catching exceptions
  def getInt(WithException: Boolean): Int =
    if (WithException) throw new RuntimeException("No int for you")
    else 42

  val potentialFail = try {
    // code that might fail
    getInt(true)
  } catch {
    case e: RuntimeException => 43
  } finally {
    // code that will get executed no matter what
    // optional
    // does not influence return type of the expression
    // use finally only for side effects
    println("finally")
  }
  println(potentialFail)

  // 3. defining my own Exceptions
  class MyExceptions extends Exception
  val exception = new MyExceptions

  throw exception
  /*
  1. crash code with OutOfMemoryError
  2. crash code with StackOverflowError
  3. PocketCalculator
    -add
    -subtract
    -multiply
    -divide

    Throw
      - OverflowError if add(x,y) exceeds Int.max_value
      - UnderFlowException if subtract(x,y) exceeds Int.MIN_value
      - MathCalculation exception for division by 0
   */

  //1.
  val array = Array.ofDim(Int.MaxValue)

  //2.
  def infinite: Int = 1 +  infinite
  val noLimit = infinite

  //3.
  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by 0")
  object PocketCalculator {
    def add(x:Int, y:Int) = {
      val result = x + y
      if(x > 0 || y > 0 && result < 0) throw new OverflowException
      else if (x < 0 || y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def subtract(x:Int, y:Int) = {
      val result = x - y
      if( x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 || y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def multiply(x:Int, y:Int) = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result

    }
    def divide(x:Int, y:Int) = {
      if (y == 0) throw new MathCalculationException
      else x/y
    }
  }

}
