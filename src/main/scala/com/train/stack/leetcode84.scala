package com.train.stack

import collection.mutable.Stack
object leetcode84 {
  def largestRectangleArea(heights: Array[Int]): Int = {
    var area = 0
    val stack = Stack[Int]()
    val heightsNew = heights.toList.:+(0)
    val length = heightsNew.length
    for(i<-Range(0,length)){
      while(!stack.isEmpty && heightsNew(i)< heightsNew(stack.top)){
        val h =heightsNew(stack.pop())
        var l = 0
        val r = i
        if(stack.isEmpty){
          l = -1
        }else{
          l=stack.top
        }
        area = math.max(area,h*(r-l-1))
        println(l,r,h,h*(r-l-1))
      }
      stack.push(i)
    }
    return area
  }

  def main(args: Array[String]): Unit = {
    //println(largestRectangleArea(Array(2,1,5,6,5,2,3)))
    //println(largestRectangleArea(Array(1)))
    println(largestRectangleArea(Array(0,2,1,2)))
  }
}
