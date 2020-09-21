package com.train.leetcode.backtrace
import scala.collection.mutable.ListBuffer

object leetcode39 {

  def _combinationSum(candidates: Array[Int], target: Int):ListBuffer[List[Int]] = {
    val res = ListBuffer[List[Int]]()
    if(candidates.isEmpty){
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
    val rr = _combinationSum(candidates.slice(0,candidates.length),target - first)
    rr.foreach(r=>{
      res.append(first +: r )
    })
    val rrr = _combinationSum(candidates.slice(1,candidates.length),target )
    rrr.foreach(r=>{
      res.append(r)
    })
    res
  }

  def combinationSum(candidates: Array[Int], target: Int): List[List[Int]] = {
    _combinationSum(candidates,target).toList
  }

  def main(args: Array[String]): Unit = {
    val res = combinationSum(Array(2,3,5),8)
    println(res)
  }

}
