package com.train.leetcode.backtrace


import scala.collection.mutable.ListBuffer

object leetcode93 {

  def _restoreIpAddresses(s: String,count:Int): ListBuffer[String] = {
    val res = ListBuffer[String]()
    if(count==1){
      res += s
      return res
    }
    if(s.length==0){
      return res
    }

    for(i <- Range(1,4)){
      val first = s.slice(0,i)
      if((!(first.length>1 && first.startsWith("0")))&&(first.toInt<=255)&&((s.length-i)>=count-1)&&(s.length-i)<=((count-1)*3)){
        val rr = _restoreIpAddresses(s.slice(i,s.length),count-1)
        for(r <- rr){
          if(count==2 && r.toInt<=255 && !(r.length>1 && r(0)=='0')){
            res += first+"."+r
          }
          if(count!=2){
            res += first+"."+r
          }
        }
      }

    }

    res
  }


  def restoreIpAddresses(s: String): List[String] = {
    this._restoreIpAddresses(s,4).toList
  }

  def main(args: Array[String]): Unit = {
    val s = ""
    val res = restoreIpAddresses(s)
    println(res)
  }
}
