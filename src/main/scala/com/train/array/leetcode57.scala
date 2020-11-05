package com.train.array

import scala.collection.mutable.ListBuffer
object leetcode57 {

  def insert(intervals: Array[Array[Int]], newInterval: Array[Int]): Array[Array[Int]] = {
    var p = newInterval(0)
    var q = newInterval(1)
    var placed  = false
    val res = ListBuffer[Array[Int]]()
    intervals.foreach(x=>{
      val s = x(0)
      val e = x(1)
      if(s>q){
        if(!placed){
          res.append(Array(p,q))
          placed=true
        }
        res.append(x)
      }else if(e<p){
        res.append(x)
      }else{
        p = Math.min(p,s)
        q = Math.max(q,e)
      }
    })
    if(!placed){
      res.append(Array(p,q))
    }
    return res.toArray
  }

  def main(args: Array[String]): Unit = {
    val r1 = insert(Array(Array(1,4),Array(9,11)),Array(2,7))
    val r2 = insert(Array(Array(1,4),Array(9,11)),Array(2,10))
    val r3 = insert(Array(Array(1,4),Array(9,11)),Array(6,7))
    val r4 = insert(Array(Array(1,4),Array(9,11)),Array(0,7))
    val r5 = insert(Array(Array(1,4),Array(0,10)),Array(0,7))
    val r6 = insert(Array(Array(1,3),Array(6,9)),Array(2,5)) //[[1,5],[6,9]]
    val r7 = insert(Array(Array(1,2),Array(3,5),Array(6,7),Array(8,10),Array(12,6)),Array(4,8))//[[1,2],[3,10],[12,16]]
  }
}
