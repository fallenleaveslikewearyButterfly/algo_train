package com.train.number

object leetcode1323 {
  def maximum69Number (num: Int): Int = {
    var s = num.toString.toCharArray
    var index = s.indexOf('6')
    if(index>=0){
      s(index) = '9'
    }
    return s.mkString.toInt
  }

  def main(args: Array[String]): Unit = {
    println(maximum69Number(9669))
    println(maximum69Number(9996))
  }
}
