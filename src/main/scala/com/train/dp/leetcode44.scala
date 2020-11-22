package com.train.dp
import scala.util.control.Breaks._

object leetcode44 {
  def isMatch(s: String, p: String): Boolean = {
    val dp = Array.fill(s.length+1,p.length+1)(false)
    dp(0)(0) = true
    breakable{
      for(i<-Range(1,p.length+1)){
        if(p(i-1) == '*') {
          dp(0)(i) = true
        }else{
          break()
        }
      }
    }
    for(i<-Range(1,s.length+1)){
      for(j<-Range(1,p.length+1)){
        if(p(j-1)=='*')
          dp(i)(j) = dp(i)(j-1)||dp(i-1)(j)
        else if(p(j-1)=='?' || p(j-1)==s(i-1))
          dp(i)(j) = dp(i-1)(j-1)
      }
    }
    return dp(s.length)(p.length)
  }

  def main(args: Array[String]): Unit = {
    println(isMatch("aa","a"))//false
    println(isMatch("aa","*"))//true
    println(isMatch("cb","?a"))//false
    println(isMatch("adceb","*a*b"))//true
    println(isMatch("acdcb","a*c?b"))//false
  }
}
