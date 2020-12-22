package com.train.dp.leetcode44

object leetcode746 {
  def minCostClimbingStairs(cost: Array[Int]): Int = {
    val dp = Array.ofDim[Int](cost.length+1)
    dp(0) = 0
    dp(1) = cost(0)
    for(i<-Range(1,cost.length)){
      dp(i+1) = Math.min(dp(i)+cost(i),dp(i-1)+cost(i))
    }

    return Math.min(dp(cost.length),dp(cost.length-1))

  }

  def main(args: Array[String]): Unit = {
    println(minCostClimbingStairs(Array(10, 15, 20)))//15
    println(minCostClimbingStairs(Array(1, 100, 1, 1, 1, 100, 1, 1, 100, 1)))//6
  }
}
