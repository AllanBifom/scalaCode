package FunctionalProgramming

import scala.annotation.tailrec
import scala.collection.IterableOnce.iterableOnceExtensionMethods
import scala.language.postfixOps

object TuplesAndMaps extends App{
  // tuples  = finite ordered "Lists"
  val aTuple =  (2,"hello, scala")// Tuple2[Int, String] = (int, String)

  println(aTuple._1) // this will print 2
  println(aTuple.copy(_2 = "goodbye java")) // creates a copy, and replaces
  println(aTuple.swap) //("hello scala", 2)

  // maps - keys -> values
  val aMap: Map[String,Int] = Map()

  val Phonebook = Map(("Jim",555),("daniel",780), "allan"->306)
  // .withDefaultValue(-1) returns -1 for keys that do not exist
  // a->b is sugar for (a,b)
  println(Phonebook)

  // map ops
  println(Phonebook.contains("Jim"))
  println(Phonebook("Jim"))

  // add a pairing
  val newPairing = "Mary" -> 678
  val newPhoneBook = Phonebook + newPairing
  println(newPhoneBook)

  // functionals on maps
  // map, flatMap, filter

  println(Phonebook.map(pair => pair._1.toLowerCase -> pair._2))

  // filterkeys
  println(Phonebook.filterKeys(x => x.startsWith("J")))

  // mapValues
  println(Phonebook.mapValues(number => "0245-" + number))

  // conversions to other collections
  println(Phonebook.toList)
  println(List(("Daniel",555)).toMap)

  val names = List("james","john", "peter","simon", "andrew")
  println(names.groupBy(name => name.charAt(0)))

  /*
  Exercises
  1. What would happen if I had 2 original entries "Jim" -> 555 and "JIM" -> 900?
  !!! answer: Careful with mapping keys
  2. Overly simplified social network based on maps
      person = String
      - add a person to the network
      - remove
      - friend(mutual)
      - unfriend

      - number of friends of a Person
      - person with most friends
      - how many people have no friends
      - if there is a social connection between two people (direct or not)


   */
  // 2
  def add(network: Map[String, Set[String]], person: String): Map[String,Set[String]] = {
    network + (person -> Set())
  }
  def friend(network: Map[String, Set[String]], a: String, b:String): Map[String,Set[String]] ={
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA + b)) + (b -> (friendsB + a))
  }

  def unfriend(network: Map[String, Set[String]],a: String,b: String): Map[String,Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA - b)) + (b -> (friendsB + a))
  }
  def remove(network: Map[String, Set[String]],person: String): Map[String,Set[String]] = {
    @tailrec
    def removeAux(friends: Set[String], networkAcc:Map[String,Set[String]]): Map[String,Set[String]] = {
      if (friends.isEmpty) networkAcc
      else removeAux(friends.tail, unfriend(networkAcc, person, friends.head))
    }
    val unfriended = removeAux(network(person), network)
    unfriended - person
  }
  println("***********************************************")

  // testing
  val empty: Map[String,Set[String]]  = Map()
  val network = add(add(empty, "Allan"),"joe")
  println(network)
  println(friend(network,"Allan","joe"))
  println(unfriend(friend(network,"Allan","joe"),"Allan","joe"))
  println(remove(friend(network,"Allan","joe"),"Allan"))

  // bob mary and jim
  val people = add(add(add(empty, "bob"),"jim"), "mary")
  val jimBob = friend(people,"bob","jim")
  val testNet = friend(jimBob,"bob","mary")

  println(testNet)

  def nFriends(network: Map[String, Set[String]],person: String): Int = {
    if(!network.contains(person)) 0
    else network(person).size
  }

  println(nFriends(testNet, "Bob"))

  def mostFriends(network: Map[String, Set[String]]): String ={
    network.maxBy(pair => pair._2.size)._1
  }

  def nPeopleWithNoFriends(network: Map[String, Set[String]]): Int = {
    network.filterKeys(k => network(k).isEmpty).size
    //network.count(pair => pair._2.isEmpty) alternate implementation
  }

  def socialConnection(network: Map[String, Set[String]],a: String,b:String): Boolean ={
    def bfs(target: String, consideredPeople: Set[String], discoveredPeople: Set[String]): Boolean ={
      if(discoveredPeople.isEmpty) false
      else{
        val person = discoveredPeople.head
        if (person == target) true
        else if (consideredPeople.contains(person)) bfs(target,consideredPeople, discoveredPeople.tail)
        else bfs(target,consideredPeople + person, discoveredPeople.tail ++ network(person))
      }
    }
    bfs(b, Set(), network(a) + a)
  }

  println(socialConnection(testNet,"mary","jim"))
  println(socialConnection(jimBob,"mary","bob"))

}
