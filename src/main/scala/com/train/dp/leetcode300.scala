package com.train.dp

object leetcode300 {
  def lengthOfLIS(nums: Array[Int]): Int = {
    val dp = Array.fill(nums.length)(1)
    for(i<-Range(0,nums.length)){
      for(j<-Range(0,i)){
        if(nums(i)>nums(j)){
          dp(i) = Math.max(dp(j)+1,dp(i))
        }
      }
    }
    return if(dp.length>0) dp.max else 0
  }
}
