package FunctionalProgramming

object HOFandCURRIES extends App{
  // map flatmap anf filter are examples

  // function that applies another function n times a given value x
  // nTimes(f, n, x)
  // nTimes(f, 3, x) = f(f(f(x))) = nTimes(f,2,f(x))
  def nTimes(f:Int => Int, n:Int, x:Int):Int ={
    if (n <= 0) x
    else nTimes(f, n-1, f(x))
  }
  val plusOne = (x: Int) => x + 1
  val minusOne: Int => Int = _ - 1

  println(nTimes(minusOne,4,10))

  // nTB(f,n) = x => f(f(f...(x)))
  // increment10 = nTB(plusOne, 10) = x => plusOne(plusOne....(x))
  // val y = increment10(1)
  def nTimesBetter(f:Int => Int, n:Int): (Int => Int) ={
    if(n <= 0) (x: Int)=> x
    else (x:Int) => nTimesBetter(f, n-1) (f(x))
  }
  val plus10 = nTimesBetter(plusOne, 10)
  println(plus10(10))

  // curried functions
  val superAdder: Int => (Int => Int) = (x:Int) =>(y:Int) => x + y
  val add3 = superAdder(3) // y => y + 3

  // functions with multiple parameter list
  def curriedFormatter(c: String)(x:Double): String = c.format(x)

  val StandardFormat: (Double => String) =  curriedFormatter("%4.2f")
  val preciseFormat: (Double => String) = curriedFormatter("%10.8f")

  // exercises
  /*
  1. expand generic list
    -foreach method A => Unit
      [1,2,3].foreach(x => println(x))

    -sort function ((A,A) => Int) => MyList
      [1,2,3].sort((x,y) => y - x) => [3,2,1]

    - zipWith (list, (A,A) => B) => MyList[B]
      [1,2,3].zipWith([4,5,6], x * y ) => [1*4,2*5,3*6] = [4,10,18]

    - fold(start)(function) => a value
      [1,2,3].fold(0) (x+y) = 6

  2. toCurry(f:(Int,Int) => Int) => (Int => Int => Int)
      fromCurry(f:(Int => Int => Int)): (Int, Int) => Int

  3. compose(f,g) => x => f(g(x))
     andThen(f,g) => x => g(f(x))
   */
  def toCurry(f:(Int,Int) => Int): (Int => Int => Int) ={
    x => y => f(x,y)
  }
  def fromCurry(f:(Int => Int => Int)): (Int, Int) => Int = {
    (x,y) => f(x)(y)
  }
  def compose[A,B,T](f:A => B, g:T => A): T => B ={
    x => f(g(x))
  }
  def andThen[A,B,C](f:A => B, g:B => C): A => C ={
    x => g(f(x))
  }
}
