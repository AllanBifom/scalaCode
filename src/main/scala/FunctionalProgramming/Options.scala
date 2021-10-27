package FunctionalProgramming

import scala.language.postfixOps
import scala.util.Random

object Options extends App{

  val myFirstOption: Option[Int] = Some(1)
  val noOption: Option[Int] = None

  println(myFirstOption)

  // were invented to deal with unsafe APIs

  def unsafeMethod(): String = null
  // val result = Some(unsafeMethod) // WRONG
  val result = Option(unsafeMethod()) // Some or None
  println(result)

  // options will be used in chained methods
  def backupMethod(): String = "A valid result"
  val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod()))

  // Design unsafe APIs
  def betterUnsafeMethods(): Option[String] = None
  def betterbackupMethods(): Option[String] = Some("A valid result")

  val betterchainedresult = betterUnsafeMethods() orElse betterbackupMethods()

  // functions on option
  println(myFirstOption.isEmpty)
 // println(myFirstOption.get) // unsafe
  // map, flatMap, Filter
  println(myFirstOption.map(_*2))
  println(myFirstOption.filter(x => x > 10))
  println(myFirstOption.flatMap(x => Option(x * 10)))

  // for comprehensions
  /*
  Exercises
   */
  val config: Map[String, String] = Map(
    "host" -> "176.45.36.1",
    "port" -> "80"
  )
  class Connection {
    def connect = "connected" // connect to some server
  }
  object Connection {
    val random = new Random(System.nanoTime())

    def apply(host: String, port:String): Option[Connection] = {
      if (random.nextBoolean()) Some(new Connection)
      else None
    }
  }

   // try and establish a connection, if you can, print the connect method
  val host = config.get("host")
  val port = config.get("port")
  /*
  if (h != null)
    if(p != null)
      return connection.apply(h,p)
   */
  val connection = host.flatMap(h => port.flatMap(p => Connection.apply(h,p)))
  /*
  if (c != null)
    return c.connect
  return null
   */
  val connectionStatus = connection.map(c => c.connect)

  // if (connectionStatus == null) print(None) else print (Some(connectionStatus.get))
  println(connectionStatus)

  /*
  if (status != null) print(status)
   */
  connectionStatus.foreach(println)

    // CHAINED SOLUTION
  config.get("host").
    flatMap(host => config.get("port")
    .flatMap(port => Connection(host, port))
    .map(Connection => Connection.connect))
    .foreach(println)

  // for comprehensions
  val forConnectionStatus = for {
    host <- config.get("host")
    port <- config.get("port")
    connection <-  Connection(host, port)
  } yield connection.connect
  forConnectionStatus.foreach(println)
}
