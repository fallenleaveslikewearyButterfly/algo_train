package com.train.leetcode.backtrace

import scala.collection.mutable.ListBuffer

object leetcode40 {

  def _combinationSum2(candidates: Array[Int], target: Int):ListBuffer[List[Int]] = {
    val res = ListBuffer[List[Int]]()
    if(candidates.isEmpty || (candidates.length==1 && candidates(0)<target)){
      return res
    }
    val minValue = candidates.min
    if(target<minValue){
      return res
    }
    if(target==minValue){
      res.append(List(minValue))
      return res
    }
    val first = candidates(0)
    if(target - first == 0){
      res.append(List(target))
    }



    val rr = _combinationSum2(candidates.slice(1,candidates.length),target - first)
    rr.foreach(r=>{
      res.append(first +: r )
    })

    var t=1
    while(t<candidates.length && candidates(t)==first){
      t+=1
    }

    val rrr = _combinationSum2(candidates.slice(t,candidates.length),target )
    rrr.foreach(r=>{
      res.append(r)
    })
    res
  }

  def combinationSum2(candidates: Array[Int], target: Int): List[List[Int]] = {
    _combinationSum2(candidates.sorted,target).toList
  }

  def main(args: Array[String]): Unit = {
    val res = combinationSum2(Array(1,1),2)
    println(res)
  }
}
