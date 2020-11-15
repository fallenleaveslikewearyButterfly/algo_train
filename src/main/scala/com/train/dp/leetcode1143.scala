package com.train.dp

object leetcode1143 {
  def longestCommonSubsequence(text1: String, text2: String): Int = {
    val dp = Array.ofDim[Int](text1.length+1,text2.length+1)
    for(i<-Range(1,text1.length+1)){
      for(j<-Range(1,text2.length+1)){
        if(text1(i-1)==text2(j-1)){
          dp(i)(j) = dp(i-1)(j-1) + 1
        }else{
          dp(i)(j) = Math.max(dp(i)(j-1),dp(i-1)(j))
        }
      }
    }

    return dp(text1.length)(text2.length)

  }

  def main(args: Array[String]): Unit = {
    println(longestCommonSubsequence("abcde", "ace" ))//3
    println(longestCommonSubsequence("abc", "abc" ))//3
    println(longestCommonSubsequence("abc", "def" ))//0
  }
}
