package com.train.array

import scala.collection.mutable.Map
object leetcode1512 {
  def numIdenticalPairs(nums: Array[Int]): Int = {
    val map = Map[Int,Int]()
    nums.foreach(x=>{
      if(!map.contains(x)){
        map(x) =0
      }
      map(x) += 1
    })
    var res = 0
    map.values.foreach(v=>{
      res += v*(v-1)/2
    })
    return res
  }
}
