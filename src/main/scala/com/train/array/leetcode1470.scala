package com.train.array

object leetcode1470 {
  def shuffle(nums: Array[Int], n: Int): Array[Int] = {
    val res = Array.fill(nums.length)(0)
    for(i<-Range(0,nums.length/2)){
      res(i*2) = nums(i)
    }
    for(i<-Range(nums.length/2,nums.length)){
      res(2*(i-nums.length/2)+1)= nums(i)
    }
    return res
  }
}
