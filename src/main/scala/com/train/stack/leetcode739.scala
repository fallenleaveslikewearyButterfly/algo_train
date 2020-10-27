package com.train.stack

import scala.collection.mutable.Stack
object leetcode739 {
  val stack = Stack[Int]()
  def dailyTemperatures(T: Array[Int]): Array[Int] = {
    stack.clear()
    val res = Array.ofDim[Int](T.length)
    for(i<-Range(0,T.length)){
      while(!stack.isEmpty && T(i)>T(stack.top)){
        val pre=stack.pop()
        res(pre)=i-pre
      }
      stack.push(i)
    }
    res
  }

  def main(args: Array[String]): Unit = {
    dailyTemperatures(Array(73, 74, 75, 71, 69, 72, 76, 73))
  }
}
