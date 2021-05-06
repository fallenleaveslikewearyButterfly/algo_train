package com.train.dp

object leetcode05 {

  def longestPalindrome(s: String): String = {
    val dp = Array.ofDim[Boolean](s.length,s.length)
    var res = ""
    for(j<-Range(0,s.length)){
      for(i<-Range(0,j+1)){
        if(s(i)==s(j)&&(j-i<2||dp(i+1)(j-1))){
          dp(i)(j) = true
        }
        if (dp(i)(j) &&  j - i + 1 > res.length()) {
          res = s.substring(i, j + 1);
        }

      }
    }
    return res
  }

  def main(args: Array[String]): Unit = {
    println(longestPalindrome("babad"))//bab
    println(longestPalindrome("cbbd"))//bb
    println(longestPalindrome("a"))//a
    println(longestPalindrome("ac"))//a
  }
}
