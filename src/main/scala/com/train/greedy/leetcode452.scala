package com.train.greedy

object leetcode452 {
  def findMinArrowShots(points: Array[Array[Int]]): Int = {
    if(points.length<=1){
      return points.length
    }
    val pointsSorted = points.sortWith((a,b)=>{
      if(a(1)==b(1)){
        a(0)<b(0)
      }else{
        a(1)<b(1)
      }
    })
    var res = 1
    var pre = pointsSorted(0)
    for(i<-Range(1,pointsSorted.length)){
      if(pointsSorted(i)(0)>pre(1)){
        res += 1
        pre = pointsSorted(i)
      }
    }
    return res
  }

  def main(args: Array[String]): Unit = {
    println(findMinArrowShots(Array(
      Array(10,16),
      Array(2,8),
      Array(1,6),
      Array(7,12)
    )))//2
  }
}
