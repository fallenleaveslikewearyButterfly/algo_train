package com.train.Greedy

object leetcode861 {
  def matrixScore(A: Array[Array[Int]]): Int = {
    val m = A.length
    val n = A(0).length
    var res = m*(1<<(n-1))

    for(i<-Range(1,n)){
      var ones = 0
      for(j<-Range(0,m)){
        if(A(j)(0)==1){
          ones += A(j)(i)
        } else {
          ones += 1 - A(j)(i)
        }
      }
      var k = Math.max(ones,m-ones)
      res += k*(1<<(n-i-1))
    }
    return res
  }

  def main(args: Array[String]): Unit = {
    println(matrixScore(
      Array(
        Array(0,0,1,1),
        Array(1,0,1,0),
        Array(1,1,0,0)
      )
    ))//39
  }
}
