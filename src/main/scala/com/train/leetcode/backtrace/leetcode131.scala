package com.train.leetcode.backtrace
import scala.collection.mutable.ListBuffer

object leetcode131 {

  def _partition(s:String):ListBuffer[List[String]]={
    if(s.length == 1){
      return ListBuffer(List(s))
    }else if(s.length==0){
      return ListBuffer[List[String]]()
    }else{
      var res = ListBuffer[List[String]]()
      for(i<-Range(1,s.length+1)){
        val first = s.slice(0,i)
        if(first.reverse == first){
          val rr = partition(s.slice(i,s.length))
          if(rr.length==0){
            res.append(List(first))
          }
          for(r <- rr){
           res.append(first :: r)
          }
        }
      }
      res
    }
  }

  def partition(s: String): List[List[String]] = {
    _partition(s).toList
  }

  def main(args: Array[String]): Unit = {
    val res = partition("aaba")
    print(res)
  }
}
