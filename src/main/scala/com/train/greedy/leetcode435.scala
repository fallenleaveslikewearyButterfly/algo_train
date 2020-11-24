package com.train.greedy

object leetcode435 {
  def eraseOverlapIntervals(intervals: Array[Array[Int]]): Int = {
    if(intervals.length<=1){
      return 0
    }
    val intervalsSorted = intervals.sortWith((a,b)=>{
      if(a(1)==b(1)){
        a(0)<b(0)
      }else{
        a(1)<b(1)
      }
    })
    var res = 1
    var pre = intervalsSorted(0)
    for(i<-Range(1,intervalsSorted.length)){
      if(intervalsSorted(i)(0)>=pre(1)){
        res +=1
        pre = intervalsSorted(i)
      }
    }
    return intervals.length-res
  }

  def main(args: Array[String]): Unit = {
    println(eraseOverlapIntervals(
      Array(
        Array(1,2),
        Array(2,3),
        Array(3,4),
        Array(1,3)
      )
    ))//1
    println(eraseOverlapIntervals(
      Array(
        Array(1,2),
        Array(1,2),
        Array(1,2)
      )
    ))//2
    println(eraseOverlapIntervals(
      Array(
        Array(1,2),
        Array(2,3)
      )
    ))//0
  }
}
