package com.train.dp

object leetcode10 {
  def isMatch(s: String, p: String): Boolean = {
    if(p==""){
      return s==""
    }
    val firstMatch = (s.length>0) && (p(0)==s(0) || p(0)=='.')
    if(p.length>=2 && p(1) == '*'){
      return isMatch(s,p.slice(2,p.length)) || (firstMatch && isMatch(s.slice(1,s.length),p))
    }
    return firstMatch && isMatch(s.slice(1,s.length),p.slice(1,p.length))

  }

  def main(args: Array[String]): Unit = {
    println(isMatch("aa","a"))//false
    println(isMatch("aa","a*"))//true
    println(isMatch("aa",".*"))//true
    println(isMatch("aab","c*a*b"))//true
    println(isMatch("mississippi","mis*is*p*."))//false
  }
}
