package com.train.array

object leetcode674 {
  def findLengthOfLCIS(nums: Array[Int]): Int = {
    var max = 0
    var index = 1
    var tCount=1
    while(index<nums.length){
      if(nums(index)>nums(index-1)){
        tCount += 1
      }else{
        max=Math.max(max,tCount)
        tCount=1
      }
      index+=1
    }
    return if(nums.length==0) 0 else Math.max(max,tCount)
  }

  def main(args: Array[String]): Unit = {
    println(findLengthOfLCIS(Array(1,3,5,7)))//4
    println(findLengthOfLCIS(Array(1,3,5,4,7)))//3
    println(findLengthOfLCIS(Array(2,2,2,2,2)))//1
    println(findLengthOfLCIS(Array(10,9,2,5,3,7,101,18)))//3
  }
}
