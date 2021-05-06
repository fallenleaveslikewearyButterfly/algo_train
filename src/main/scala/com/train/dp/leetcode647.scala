package com.train.dp.leetcode44

object leetcode647 {

  def countSubstrings(s: String): Int = {
    val dp = Array.ofDim[Boolean](s.length,s.length)

    var count = 0
    for(j<-Range(0,s.length)){
      for(i<-Range(0,j+1)){
        if(s(i)==s(j)&&(j-i<2||dp(i+1)(j-1))){
          dp(i)(j) = true
          count += 1
        }
      }
    }
    count
  }

  def main(args: Array[String]): Unit = {
    println(countSubstrings("abc"))//3
    println(countSubstrings("aaa"))//6
    println(countSubstrings("abca"))//4
  }
}
