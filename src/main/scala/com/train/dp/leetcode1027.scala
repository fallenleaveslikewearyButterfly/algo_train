package com.train.dp

object leetcode1027 {
  def longestArithSeqLength(A: Array[Int]): Int = {

    val dp = Array.fill(A.length+1,A.length+1)(2)
    var res = 0
    for(i<-Range(1,A.length)){
      for(j<-Range(0,i)){
        val target = A(j) - (A(i) -A(j))
        for(k<-Range(0,j)){
          if(A(k) == target){
            dp(i)(j) = Math.max(dp(j)(k)+1,dp(i)(j))
          }
        }
        res = Math.max(dp(i)(j),res)
      }
    }
    return res
  }

  def main(args: Array[String]): Unit = {
    print(longestArithSeqLength(Array(3,6,9,12)))//4
    print(longestArithSeqLength(Array(9,4,7,2,10)))//3
    print(longestArithSeqLength(Array(20,1,15,3,10,5,8)))//4
    print(longestArithSeqLength(Array(83,20,17,43,52,78,68,45)))//2
  }
}
