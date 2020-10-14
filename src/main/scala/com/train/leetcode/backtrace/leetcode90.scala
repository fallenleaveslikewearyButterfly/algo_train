package com.train.leetcode.backtrace

import scala.collection.mutable.{ListBuffer}

object leetcode90 {

  val res = ListBuffer[List[Int]]()
  val rr = ListBuffer[Int]()

  def _subsetsWithDup(index:Int,nums: Array[Int]): Unit = {
    res.append(rr.toList)

    for(i<-Range(index,nums.length) if !(i>index && nums(i)==nums(i-1))){
      rr.append(nums(i))
      _subsetsWithDup(i+1,nums)
      rr.trimEnd(1)
    }
  }

  def subsetsWithDup(nums: Array[Int]): List[List[Int]] = {
    res.clear()
    rr.clear()
    _subsetsWithDup(0,nums.sorted)
    res.toList
  }

  def main(args: Array[String]): Unit = {
    println(subsetsWithDup(Array(1,2,2,2,2)))
  }
}
