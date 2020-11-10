package com.train.array

object leetcode31 {

  def reverse(nums:Array[Int],start:Int): Unit ={
    var left =start
    var right = nums.length-1
    while(left<right){
      val t=nums(left)
      nums(left) = nums(right)
      nums(right)=t
      left += 1
      right -= 1
    }
  }

  def nextPermutation(nums: Array[Int]): Unit = {
    var i = nums.length - 2
    while(i>=0 && nums(i)>=nums(i+1)){
      i-=1
    }
    if(i>=0){
      var j = nums.size-1
      while(j>=0 && nums(i)>=nums(j)){
        j-=1
      }
      val t = nums(i)
      nums(i) = nums(j)
      nums(j) = t
    }
    reverse(nums, i + 1);
  }

  def main(args: Array[String]): Unit = {
    println(nextPermutation(Array(1,2,3)))//1,3,2
    println(nextPermutation(Array(3,2,1)))//1,2,3
    println(nextPermutation(Array(1,1,5)))//1,5,1
  }
}
