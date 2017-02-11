package cs4r.labs.learningscala.otherexercises

import scala.collection.immutable.Vector

/**
  * Created by cs4r on 5/02/17.
  */
object Collections extends App {


  import collection.JavaConverters._
  import collection._

  val listOfInts: List[Int] = List(1, 2, 3, 4, 5, 6)

  listOfInts.toArray

  val vectorOfInts = Vector(1, 2, 3, 4, 5)

  vectorOfInts.toStream.foreach(println)

  vectorOfInts.toSet.foreach(println)

  val list1 = mutable.ListBuffer(1, 2, 3)

  val j1 = list1.asJava

  val j2: java.util.List[Int] = list1.asJava

  import java.util.{List => JList}

  val j3: JList[Int] = list1.asJava

  assert(list1 eq j3.asScala)

  val i1 = Iterator(1, 2, 3)

  val i2 = i1.asJava.asScala

  assert(i1 eq i2)

  import java.util.{Set => JSet}

  val set = immutable.HashSet(1, 2, 3, 4)

  val jSet = set.asJava

  assert(set ne jSet.asScala)


  def getEnv(s: String): List[String] = {
    System.getenv().asScala.filterKeys(_.toLowerCase.contains(s.toLowerCase)).map(_._2).toList
  }

  println(getEnv("PATH").mkString("\n"))

  println(getEnv("java").mkString("\n"))

}
