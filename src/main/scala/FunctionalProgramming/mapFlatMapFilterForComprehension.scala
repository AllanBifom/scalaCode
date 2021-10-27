package FunctionalProgramming

object mapFlatMapFilterForComprehension extends App{

  // official versions
  val newList = List(1,2,3)
  println(newList.head)
  println(newList.tail)

  // map
  println(newList.map(_+1))

  // filter
  println(newList.filter(_%2==0))

  // FlatMap
  val toPair = (x: Int) => List(x, x+1)
  println(newList.flatMap(toPair))

  /*
  Small exercise
  // print out all combinations between 2 lists
   */
  val numbers = List(1,2,3,4)
  val chars = List("a","b","c","d")
  val colours = List("black","white")
  // a1,a2,a3,....... d3,d4

  val combinations = numbers.flatMap(n => chars.map(c=> ""+ c + n))
  println(combinations)

  val combinations2 = numbers.flatMap(n => chars.flatMap(c => colours.map(color => "" + c + n +"-"+ color )))
  println(combinations2)
  // End of exercise

  val combinations3 = numbers.filter(_%2 == 0).flatMap(n => chars.flatMap(c => colours.map(color => "" + c + n +"-"+ color )))

  // for each
  numbers.foreach(println)

  // for comprehensions
  var forCombinations = for {
    n <- numbers
    c <- chars
    colour <- colours
  } yield "" + c + n + "-" + colour
  println(forCombinations)

  // you can also filter this out.
  var forCombinations3 = for {
    n <- numbers if n%2 == 0
    c <- chars
    colour <- colours
  } yield "" + c + n + "-" + colour
  println(forCombinations3)

  for {
    n <- numbers
  } println(n)

  // syntax overload
  newList.map { x =>
    x * 2
  }
  /*
  Exercises
  1. See if MyList supports for comprehensions: Yes it does
      map(f: A => B) => MyList[B]
      filter(p: A => Boolean) => MyList[A]
      flatMap(f: A => MyList[B]) => MyList[B]
  2. A small collection of at most one element - Maybe[+T]
    - map, flatMap and filter for this collection.
   */





}
