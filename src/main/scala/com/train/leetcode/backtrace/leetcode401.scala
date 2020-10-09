package com.train.leetcode.backtrace

import scala.collection.mutable.ListBuffer

object leetcode401 {

  val res = ListBuffer[String]()

  def _readBinaryWatch(n: Int,index:Int,hours:Int,minutes:Int):Unit = {
    var hour = hours
    var minute = minutes

    if(n==0){
      if(hour <= 11 && minute<=59){
        if(minutes<10){
          res.append(hours.toString+":0"+minutes.toString)
        }else{
          res.append(hours.toString+":"+minutes.toString)
        }
      }
      return
    }
    for(s<-Range(index,10)){
      if(s<=3){
        hour = hour+math.pow(2,s).toInt
      }else{
        minute = minute + math.pow(2,s-3-1).toInt
      }

      _readBinaryWatch(n-1,s+1,hour,minute)

      if(s<=3){
        hour = hour-math.pow(2,s).toInt
      }else{
        minute = minute - math.pow(2,s-3-1).toInt
      }
    }
  }

  def readBinaryWatch(n: Int): List[String] = {
    res.clear()
    if(n>9){
      return res.toList
    }
    _readBinaryWatch(n,0,0,0)
    res.toList
  }

  def main(args: Array[String]): Unit = {
    val r = readBinaryWatch(2)
    println(r)
  }

}
