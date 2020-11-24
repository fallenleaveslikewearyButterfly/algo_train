package com.train.array

object leetcode1480 {
  def runningSum(nums: Array[Int]): Array[Int] = {
    val preSum = Array.fill(nums.length)(0)
    preSum(0) = nums(0)
    for(i<-Range(1,nums.length)){
      preSum(i) = preSum(i-1)+nums(i)
    }
    return preSum
  }
}
