package com.train.Greedy

object leetcode455 {
  def findContentChildren(g: Array[Int], s: Array[Int]): Int = {
    val gSorted = g.sorted
    val sSorted = s.sorted
    var count = 0
    var cur = 0
    for(c<-gSorted){
      while(cur<sSorted.length && sSorted(cur)<c){
        cur+=1
      }
      if(cur<sSorted.length){
        count+=1
        cur +=1
      }
    }
    return count
  }

  def main(args: Array[String]): Unit = {
    println(findContentChildren(Array(1,2,3),Array(1,1)))//1
    println(findContentChildren(Array(1,2),Array(1,2,3)))//2
    println(findContentChildren(Array(10,9,8,7),Array(5,6,7,8)))//2
    println(findContentChildren(Array(1,2,3),Array(3)))//1
  }
}
