package com.train.map
import scala.collection.mutable.Map
object leetcode1207 {

  def uniqueOccurrences(arr: Array[Int]): Boolean = {
    val map = Map[Int,Int]()
    arr.foreach(a=>{
      if(!map.contains(a)){
        map(a)=0
      }
      map(a) += 1
    })
    return map.values.toList.length == map.values.toSet.toList.length
  }

  def main(args: Array[String]): Unit = {
    println(uniqueOccurrences(Array(1,2,2,1,1,3)))
    println(uniqueOccurrences(Array(1,2)))
    println(uniqueOccurrences(Array(-3,0,1,-3,1,1,1,-3,10,0)))

  }

}
