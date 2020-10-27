package com.train.stack

import scala.collection.mutable.Stack
import scala.util.control.Breaks._
object leetcode42 {
  def trap(height: Array[Int]): Int = {
    val stack = Stack[Int]()
    var res = 0
    val calculated = Array.fill[Int](height.length)(-1)
    for(i<-Range(0,height.length)){
      breakable{
        while(!stack.isEmpty && height(i)>height(stack.top)){
          val cur = stack.pop()
          if(stack.isEmpty){
            break()
          }
          val l = stack.top
          val r = i
          var h = Math.min(height(r),height(l))-height(cur)
          res += (r-l-1) * h
        }
      }

      stack.push(i)
    }
    return res
  }

  def main(args: Array[String]): Unit = {
    println(trap(Array(0,1,0,2,1,0,1,3,2,1,2,1)))
    println(trap(Array(4,2,0,3,2,5)))
    println(trap(Array(4,2,3)))
  }
}
