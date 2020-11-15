package com.train.array

object leetcode1292 {

  def maxSideLength(mat: Array[Array[Int]], threshold: Int): Int = {
    var res = 0
    val M = mat.length
    val N = mat(0).length
    val preSum = Array.fill(M+1,N+1)(0)
    for(i<-Range(1,M+1)){
      for(j<-Range(1,N+1)){
        preSum(i)(j) = preSum(i-1)(j) + preSum(i)(j-1) - preSum(i-1)(j-1) + mat(i-1)(j-1)
      }
    }
    var l=0
    for(i<-Range(0,M+1)){
      for(j<-Range(0,N+1)){
        while(i+l<=mat.length && j+l<=mat(0).length && preSum(i+l)(j+l)-preSum(i+l)(j)-preSum(i)(j+l)+preSum(i)(j) <= threshold){
          res = l
          l+=1
        }
      }
    }
    return res
  }

  def main(args: Array[String]): Unit = {
    println(maxSideLength(
      Array(
      Array(1,1,3,2,4,3,2),
      Array(1,1,3,2,4,3,2),
        Array(1,1,3,2,4,3,2)
      ),4
     )
    )

  }
}
