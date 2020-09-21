package com.train.leetcode.backtrace
import scala.collection.mutable.ListBuffer

object leetcode77 {

  def _combine(arr:Array[Int], k: Int):ListBuffer[List[Int]]={
    val res = ListBuffer[List[Int]]()
    if(k==1){
      arr.foreach(x=>{
        res.append(List(x))
      })
      return res
    }
    if(k>arr.length){
      return res
    }

    val first =arr(0)

    val ff  = _combine(arr.slice(1,arr.length),k-1)
    ff.foreach(x=>{
      res.append(first +: x)
    })
    _combine(arr.slice(1,arr.length),k).foreach(y=>{
      res.append(y)
    })

    res
  }

  def combine(n: Int, k: Int): List[List[Int]] = {
    _combine((1 to n).toArray,k).toList
  }

  def main(args: Array[String]): Unit = {
    val res = combine(4,3)
    println(res)
  }


}
