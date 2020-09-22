package com.train.leetcode.backtrace

import scala.collection.mutable.ListBuffer
object leetcode216 {

  val res = ListBuffer[List[Int]]()

  def _combinationSum3(k:Int,n:Int,rr:ListBuffer[Int]):Unit={
    if(k==0 && n>0){
      return
    }
    if(k==0 && n==0){
      res.append(rr.toList)
    }
    var index = -1
    if(rr.isEmpty){
      index=0
    }
    else{
      index=rr.last
    }
    for(i<-Range(index+1,10)){
        rr.append(i)
        _combinationSum3(k-1,n-i,rr)
        rr.trimEnd(1)
    }
  }

  def combinationSum3(k: Int, n: Int): List[List[Int]] = {
    res.clear()
    val rr = ListBuffer[Int]()
    if(!(k<=0 || k>9 || n==0 ||n>45)){
      _combinationSum3(k,n,rr)
    }
    res.toList
  }

  def main(args: Array[String]): Unit = {
    val res = combinationSum3(3,9)
    println(res)
  }
}
