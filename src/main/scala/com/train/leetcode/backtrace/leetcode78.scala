package com.train.leetcode.backtrace

import scala.collection.mutable.ListBuffer

object leetcode78 {

  val res = ListBuffer[List[Int]]()

  def _subsets(index:Int,nums: Array[Int],rr:ListBuffer[Int]): Unit = {
    if(index>=nums.length){
      res.append(rr.toList)
      return
    }

    rr.append(nums(index))
    _subsets(index+1,nums,rr)
    rr.trimEnd(1)
    _subsets(index+1,nums,rr)

  }

  def subsets(nums: Array[Int]): List[List[Int]] = {
    res.clear()
    val rr = ListBuffer[Int]()
    _subsets(0,nums,rr)
    res.toList
  }

  def main(args: Array[String]): Unit = {
    println(subsets(Array(1,2,3)))
  }


}
