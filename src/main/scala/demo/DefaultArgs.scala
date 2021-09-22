package demo

object DefaultArgs extends App {

  def trFact(n: Int, acc: Int = 1): Int = {
    if (n <= 1)acc
    else trFact(n-1, n*acc)
  }
  val fact10 = trFact(10)
  val fact9 = trFact(9,2) // the argument we passed will overwrite the default argument

  // Leading parameters cannot really be defaulted, because when setting arguments for the following parameters for the
  // following arguments it will confuse the compiler
  /*
  solutions
  1. Pass in every leading arguments
  2. name the argument
  e.g savePictures(width = 100)
   */
}
