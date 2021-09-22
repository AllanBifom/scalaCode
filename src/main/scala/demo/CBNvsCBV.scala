package demo

object CBNvsCBV extends App{
  def calledByValue(x:Long): Unit ={
    println("by value " + x)
    println("by value " + x)
  }
  def calledByNmae(x: => Long): Unit = {
    println("by value " + x)
    println("by value " + x)
  }

  calledByValue(System.nanoTime()) // Expression is evaluated only once
  calledByNmae(System.nanoTime()) // Expression is evaluated every time

  def infinite():Int = 1 + infinite()
  def printFirst(x:Int, y: => Int) = println(x)

  //printFirst(infinite(), 34)
  printFirst(34,infinite())
}
