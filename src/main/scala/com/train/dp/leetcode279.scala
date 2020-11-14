package com.train.dp

object leetcode279 {
  def numSquares(n: Int): Int = {
    val memo = Array.fill(n+1)(0)
    for(i<-Range(1,n+1)){
      memo(i)=i
      var j =1
      while(i-j*j>=0){
        memo(i) = Math.min(memo(i),memo(i-j*j)+1)
        j += 1
      }
    }
    return memo(n)
  }

  def main(args: Array[String]): Unit = {
    println(numSquares(5))//2
    println(numSquares(11))//3
    println(numSquares(12))//3
    println(numSquares(13))//2

  }
}
