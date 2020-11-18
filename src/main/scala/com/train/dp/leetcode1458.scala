package com.train.dp

object leetcode1458 {
  def maxDotProduct(nums1: Array[Int], nums2: Array[Int]): Int = {
    val dp = Array.fill(nums1.length+1,nums2.length+1)(-1000*1000*500)
    for(i<-Range(1,nums1.length+1)){
      for(j<-Range(1,nums2.length+1)){
        dp(i)(j) = nums1(i-1)*nums2(j-1)
        dp(i)(j) = Math.max(dp(i)(j),nums1(i-1)*nums2(j-1) +dp(i-1)(j-1))
        dp(i)(j) = Math.max(dp(i)(j),dp(i)(j-1))
        dp(i)(j) = Math.max(dp(i)(j),dp(i-1)(j))
        dp(i)(j) = Math.max(dp(i)(j),dp(i-1)(j-1))
      }
    }
    return dp(nums1.length)(nums2.length)
  }

  def main(args: Array[String]): Unit = {
    println(maxDotProduct(
      Array(2,1,-2,5),
      Array(3,0,-6)
    ))//18
    println(maxDotProduct(
      Array(3,-2),
      Array(2,-6,7)
    ))//21
    println(maxDotProduct(
      Array(-1,-1),
      Array(1,1)
    ))//21
  }
}
