package com.train.stack

import scala.collection.mutable.ArrayStack
object leetcode1544 {

  val stack = ArrayStack[Char]()

  def makeGood(s: String): String = {
    if(s==""){
      return s
    }
    stack.clear()
    s.foreach(c=>{
      if(stack.isEmpty){
        stack.push(c)
      }else{
        val t = stack.pop()
        if(t.toUpper==c.toUpper && t!=c){

        }else{
          stack.push(t)
          stack.push(c)
        }
      }
    })
    var res = ""
    stack.foreach(c=>{
      res = c+res
    })
    return res
  }

  def main(args: Array[String]): Unit = {
    println(makeGood("leEeetcode"))
    println(makeGood("abBAcC"))
  }

}
