package com.train.array

import scala.collection.mutable.ListBuffer
object leetcode56 {
  def merge(intervals: Array[Array[Int]]): Array[Array[Int]] = {
    val res = ListBuffer[Array[Int]]()
    if(intervals.length<=1){
      return intervals
    }
    val intervalsSorted = intervals.sortWith((a,b)=>{
        a(0)<b(0)
    })
    var t = intervalsSorted(0)
    for(i<-Range(1,intervals.length)){
        if(intervalsSorted(i)(0)<=t(1)){
          t(1) = intervalsSorted(i)(1)
        }else{
          res.append(t)
          t = intervalsSorted(i)
        }
    }
    res.append(t)
    return res.toArray
  }

  def main(args: Array[String]): Unit = {
//    println(merge(
//      Array(
//        Array(1,3),
//        Array(2,6),
//        Array(8,10),
//        Array(16,18)
//      )
//    ))
        println(merge(
          Array(
            Array(1,4),
            Array(2,3)
          )
        ))
  }
}
