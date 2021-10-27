package FunctionalProgramming

import scala.language.postfixOps
import scala.util.Random

object Sequences extends App{
  // sequences
  val aSequences = Seq(1,3,2,4)
  println(aSequences)
  println(aSequences.reverse)
  println(aSequences(2))
  println(aSequences ++ Seq(5,6,7))
  println(aSequences.sorted)

  // ranges
  val aRanges: Seq[Int] = 1 to 10
  aRanges.foreach(print)

  (1 to 10)foreach(x => print("Hello "))

  // lists
  /*
  Lists are immutable and extend linear Sequence
   */
  val aList = List(1,2,3)
  val prepended = 42 :: aList
  val prepended2 = 41 +: aList
  val appended = aList :+ 81
  println(appended)

  val orange5 = List.fill(5)("oranges")
  println(orange5)
  println(aList.mkString("-|-"))

  // Arrays
  val numbers = Array(1,2,3,4)
  val threeElements = Array.ofDim[Int](3) // allocates space for elements without inputting elements.
  // the values of threeElements are initialized wih some default values

  // mutations
  numbers(2) = 0
  println(numbers.mkString(""))

  // arrays and sequences
  val numberSeq: Seq[Int] = numbers // implicit conversions
  println(numberSeq)

  // Vectors
  val vector: Vector[Int] = Vector(1,2,3)
  println(vector)

  // vectors vs lists
  val maxRuns = 100
  val maxCapacity = 10000

  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      it <- 1 to maxRuns
    } yield{
      val current = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - current
    }

    times.sum * 1.0 / maxRuns
  }

  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

  // keeps reference to tails
  // updating element in the middle takes time
  println(getWriteTime(numbersList))

  // the depth of the tree is small
  // needs to replace an entire 32-element chunck
  println(getWriteTime(numbersVector))




}
