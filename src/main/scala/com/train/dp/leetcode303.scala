package com.train.dp

class NumArray(_nums: Array[Int]) {
  var preSum = Array.fill(_nums.length+1)(0)
  preSum(0)=0
  for(i<-Range(0,_nums.length)){
    preSum(i+1) = preSum(i) + _nums(i)
  }

  def sumRange(i: Int, j: Int): Int = {
    return preSum(j+1)-preSum(i)
  }

}

object leetcode303 {


  def main(args: Array[String]): Unit = {
    val n  = new NumArray(Array(-2, 0, 3, -5, 2, -1))
    println(n.sumRange(0,2))
  }
}
