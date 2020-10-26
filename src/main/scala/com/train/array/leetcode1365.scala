package com.train.array

import scala.collection.mutable.Map
object leetcode1365 {

  val map = Map[Int,Int]()

  def smallerNumbersThanCurrent(nums: Array[Int]): Array[Int] = {
    map.clear()
    nums.foreach(num=>{
      if(!map.contains(num)){
        var count=0
        nums.foreach(n=>{
          if(n<num){
            count+=1
          }
        })
        map(num) = count
      }
    })
    val arr = Array.ofDim[Int](nums.length)
    for(i<-Range(0,nums.length)){
      arr(i)=map.getOrElse(nums(i),0)
    }
    return arr
  }

  def main(args: Array[String]): Unit = {
    smallerNumbersThanCurrent(Array(8,1,2,2,3)).foreach(println)
    println()
    smallerNumbersThanCurrent(Array(6,5,4,8)).foreach(println)
    println()
    smallerNumbersThanCurrent(Array(7,7,7,7)).foreach(println)
    println()
  }

}
