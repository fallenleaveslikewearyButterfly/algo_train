package com.train.stack

import scala.collection.mutable.{Stack,Map}

object leetcode316 {
  def removeDuplicateLetters(s: String): String = {

    val stack = Stack[Char]()
    val map = Map[Int,Int]()
    val used = Array.fill(26)(false)

    s.foreach(c=>{
      if(map.contains(c)){
        map(c) += 1
      }else{
        map(c) = 1
      }
    })
    s.foreach(c=>{
      map(c) -= 1
      if(used(c-'a')==false){
        while(!stack.isEmpty && c<stack.top && map(stack.top)!=0){
          used(stack.top-'a')=false
          stack.pop()
        }
        used(c-'a')=true
        stack.push(c)
      }
    })
    var ans = ""
    while(!stack.isEmpty){
      ans = stack.pop() +ans
    }
    return ans
  }

  def main(args: Array[String]): Unit = {
    println(removeDuplicateLetters("bcabc"))//abc
    println(removeDuplicateLetters("cbacdcbc")) //acdb
    println(removeDuplicateLetters("ecbacba")) //eacb
    println(removeDuplicateLetters("abacb")) //abc
  }

}
