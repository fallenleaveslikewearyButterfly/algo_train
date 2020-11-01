package com.train.array

import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Map
import scala.collection.mutable.Set
class RandomizedCollection() {

  /** Initialize your data structure here. */
  val list = ListBuffer[Int]()
  val map = Map[Int,Set[Int]]()
  /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
  def insert(v: Int): Boolean = {
    list.append(v)
    if(map.contains(v)){
      map(v).add(list.length-1)
      return false
    }else{
      map(v)=Set(list.length-1)
      return true
    }
  }

  /** Removes a value from the collection. Returns true if the collection contained the specified element. */
  def remove(v: Int): Boolean = {
    if(map.contains(v)){
      val index = map(v).head
      list(index) = list(list.length-1)
      map(v).remove(index)
      map(list(index)).remove(list.length-1)
      map(list(index)).add(index)
      list.remove(list.length-1)
      if(map(v).isEmpty){
        map.remove(v)
      }
      return true
    }else{
      return false
    }
  }

  /** Get a random element from the collection. */
  def getRandom(): Int = {
    return list(scala.util.Random.nextInt(list.length))
  }
}

object leetcode381 {
  def main(args: Array[String]): Unit = {
    val collection = new RandomizedCollection()
    println(collection.insert(1))
    println(collection.insert(0))
    println(collection.insert(1))
    println(collection.insert(1))
    println(collection.insert(1))
    println(collection.insert(1))
    println(collection.insert(1))
    println(collection.insert(1))
    println(collection.insert(0))
    println(collection.remove(0))
    println(collection.remove(0))
  }
}
