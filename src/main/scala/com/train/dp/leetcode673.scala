package com.train.dp

object leetcode673 {
  def findNumberOfLIS(nums: Array[Int]): Int = {
    if(nums.length==0){
      return 0
    }
    val dp = Array.fill(nums.length)(1)
    val length = Array.fill(nums.length)(1)
    var max = 1
    for(i<-Range(0,nums.length)){
      for(j<-Range(0,i)){
        if(nums(i)>nums(j)){
          if(dp(j)+1>dp(i)){
            length(i) = length(j)
            dp(i) = dp(j)+1
          }else if(dp(j)+1==dp(i)){
            length(i) += length(j)
          }
          dp(i) = Math.max(dp(j)+1,dp(i))
          max = Math.max(max,dp(i))
        }
      }
    }
    var count = 0
    for(i<-Range(0,dp.length)){
      if(dp(i) == max){
        count += length(i)
      }
    }
    return count
  }

  def main(args: Array[String]): Unit = {

    println(findNumberOfLIS(Array(1,3,5,4,7)))//2
    println(findNumberOfLIS(Array(2,2,2,2,2)))//5
    println(findNumberOfLIS(Array(1,2,4,3,5,4,7,2)))//3
  }
}
