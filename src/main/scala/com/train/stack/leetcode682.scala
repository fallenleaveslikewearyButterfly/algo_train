package com.train.stack

import scala.collection.mutable.ArrayStack
object leetcode {

  val stack = ArrayStack[Int]()

  def calPoints(ops: Array[String]): Int = {
    stack.clear()
    var score = 0
    ops.foreach(c=>{
      if(c=="C"){
        stack.pop()
      }else if(c=="D"){
        val x = stack.pop()
        val y = x*2
        stack.push(x)
        stack.push(y)
      }else if(c=="+"){
        val x = stack.pop()
        val y = stack.pop()
        stack.push(y)
        stack.push(x)
        stack.push(x+y)
      }else{
        stack.push(c.toInt)
      }
    })
    stack.sum
  }

  def main(args: Array[String]): Unit = {
    val arr = Array("5","-2","4","C","D","9","+","+")
    val res = calPoints(arr)
    println(res)
  }

}
