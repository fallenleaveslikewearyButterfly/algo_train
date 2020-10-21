package com.train.stack

import scala.collection.mutable.ArrayStack


object leetcode1598 {
  val stack = ArrayStack[String]()
  def minOperations(logs: Array[String]): Int = {
    stack.clear()
    logs.foreach(c=>{
      if(c=="../"){
        if(!stack.isEmpty){
          stack.pop()
        }
      }else if(c=="./"){

      }else{
        stack.push(c)
      }
    })
    stack.length
  }

  def main(args: Array[String]): Unit = {
    val res =minOperations(Array("d1/","d2/","./","d3/","../","d31/"))
    println(res)
  }
}
