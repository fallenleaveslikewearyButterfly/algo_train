package com.train.stack

import scala.collection.mutable.ArrayStack
import scala.collection.mutable.Map

object leetcode496 {


  val stack = ArrayStack[Int]()
  val map = Map[Int,Int]()
  def nextGreaterElement(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    stack.clear()
    map.clear()
    val res = Array.ofDim[Int](nums1.length)
    for(num<-nums2){

      while(!stack.isEmpty && num>stack.top){
        map(stack.pop())=num
      }
      stack.push(num)
    }
    for(i<-Range(0,nums1.length)){
      res(i)=map.getOrElse(nums1(i),-1)
    }
    res
  }

  def main(args: Array[String]): Unit = {
    val ss = nextGreaterElement(Array(1,3,5,2,4),Array(6,5,4,3,2,1,7))
    ss.foreach(println)
  }
}
