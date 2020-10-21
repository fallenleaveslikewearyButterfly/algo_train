package com.train.stack

import scala.collection.mutable.ArrayStack

object leetcode844{



  def backspaceCompare(S: String, T: String): Boolean = {
    val stack = ArrayStack[Char]()
    S.foreach(c=>{
      if(c=='#'){
        if(!stack.isEmpty){
          stack.pop()
        }
      }else{
        stack.push(c)
      }
    })
    val s = stack.mkString
    stack.clear()
    T.foreach(c=>{
      if(c=='#'){
        if(!stack.isEmpty){
          stack.pop()
        }

      }else{
        stack.push(c)
      }
    })
    val t = stack.mkString
    if(s == t){
      return true
    }else{
      return false
    }
  }

  def main(args: Array[String]): Unit = {
    val r = backspaceCompare("a##c","#a#c")
    println(r)
  }


}