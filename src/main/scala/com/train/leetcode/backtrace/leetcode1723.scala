package com.train.leetcode.backtrace

import scala.collection.mutable.Set
object leetcode1723 {
  var res = Integer.MAX_VALUE

  private def backTrace(jobs:Array[Int],i:Int,worker:Array[Int],max:Int): Unit ={
    if(i==jobs.length){
        res = Math.min(res,max)
    }else{

      for(j<-Range(0,worker.length)){
        if(worker(j) +jobs(i) < res && set.add(worker(j))){
          worker(j) += jobs(i)
          backTrace(jobs,i+1,worker,Math.max(worker(j),max))
          worker(j) -= jobs(i)
        }
      }
    }
  }

  def minimumTimeRequired(jobs: Array[Int], k: Int): Int = {
    res = Integer.MAX_VALUE
    backTrace(jobs,0,Array.fill(k)(0),0)
    res
  }

  def main(args: Array[String]): Unit = {
    //println(minimumTimeRequired(Array(3,2,3),3))//3
    println(minimumTimeRequired(Array(1,2,4,7,8),2))//11
  }


}
