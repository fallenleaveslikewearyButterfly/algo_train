package com.train.stack

import scala.collection.mutable.ArrayStack
object leetcode1003 {

  val stack = ArrayStack[Char]()
  def isValid(s: String): Boolean = {
    stack.clear()
    s.foreach(c=>{
      if(c=='c' && !stack.isEmpty){
        if(!stack.isEmpty && stack.top=='b'){
          val t1 = stack.pop()
          if(!stack.isEmpty && stack.top == 'a'){
            stack.pop()
          }else{
            stack.push(t1)
            stack.push(c)
          }
        }
      }else{
        stack.push(c)
      }
    })
    return stack.length==0
  }

  def main(args: Array[String]): Unit = {
    println(isValid("cababc"))

  }
}
