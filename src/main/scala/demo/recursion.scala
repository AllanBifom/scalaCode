package demo

import scala.annotation.tailrec

object recursion extends App{
  def factorialFunction(n:Int):Int = {
    if (n <= 1) 1
    else {
      println("Computing factorial of "+ n +"- I first need factorial of "+ (n-1))
      val result = n * factorialFunction(n-1)
      println("computed factorial of "+ n)
      result
    }
  }
//  factorialFunction(5000)

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int,accumulator:BigInt): BigInt =
      if (x <= 1) accumulator
      else factHelper(x-1, x*accumulator) // scalar doesnt need to save stack firms . its called TAIL RECURSION
    // TAIL RECURSION- use recursive call as the LAST expression

    factHelper(n, 1)
  }
  println(anotherFactorial(5))
  /*
  another factorial of (10) = factHelper(10,1)
  =factHelper(9,10 * 1)
  =factHelper(8, 9 * 10 * 1)
  =factHelper(7, 8 * 9 * 10 * 1)
  =.....factHelper(2, 3 * 4 * 5.....* 10 *1 )
  =factHelper(1, 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 1)
  = 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 1 ( i.e  accumulator

   */

  // When You need loops use TAIL_RECURSION
  /*
  1. Concatenate a string n times
  2. prime function tail recursive
  3. Fibonacci function tail recursive
   */

  def concatenateTailRec(aString: String, n:Int, accumulator: String): String =

    if (n <= 0) accumulator
    else concatenateTailRec(aString,n-1,aString+accumulator)



  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailrec(t: Int, isStillPrime: Boolean):Boolean =
      if(!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailrec(t-1,n%t != 0 && isStillPrime)

    isPrimeTailrec(n / 2, true)

    }
    println(isPrime(629))

  def fibonacci(n: Int): Int = {
    def fiboTailrec(i:Int, last: Int, nextLast: Int): Int =
      if (i >= n) last
      else fiboTailrec(i+1,last + nextLast,last)

    if (n<=2) 1
    else fiboTailrec(2,1,1)
  }
  println(fibonacci(7))
/* the amount of recursive calls you have in the code path is the amount of accumulators you should have in the
  recursive function
 */




}
