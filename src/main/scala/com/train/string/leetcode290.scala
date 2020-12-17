package com.train.string

import scala.collection.mutable.{Map,Set}
object leetcode290 {
  def wordPattern(pattern: String, s: String): Boolean = {
    val map1  = Map[String,String]()
    val map2  = Map[String,String]()
    val t = s.split(" ")
    for(i<-Range(0,t.length)){
      if(!map1.contains(t(i))){
        map1(t(i))=""
      }
      map1(t(i)) += i
    }

    for(i<-Range(0,pattern.length)){
      if(!map2.contains(pattern(i).toString)){
        map2(pattern(i).toString)=""
      }
      map2(pattern(i).toString) += i
    }
    return map1.values.toSet == map2.values.toSet

  }

  def main(args: Array[String]): Unit = {
    println(wordPattern("aaa","aa aa aa aa"))
    println(wordPattern("abba","dog cat cat dog"))//true
    println(wordPattern("abba", "dog cat cat fish"))//false
    println(wordPattern("aaaa", "dog cat cat dog"))//false
    println(wordPattern("abba", "dog dog dog dog"))//false
  }
}
