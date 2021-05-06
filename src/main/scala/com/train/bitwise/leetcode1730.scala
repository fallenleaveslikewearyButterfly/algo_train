package com.train.bitwise

object leetcode1730 {

  def decode(encoded: Array[Int], first: Int): Array[Int] = {
    val resArr = Array.ofDim[Int](encoded.length+1)
    resArr(0) = first
    for(i<-Range(1,resArr.length)){
      resArr(i) = encoded(i-1)^resArr(i-1)
    }
    resArr
  }

  def main(args: Array[String]): Unit = {
    decode(Array(1,2,3),1).foreach(print)//[1,0,2,1]
    println()
    decode(Array(6,2,7,3),4).foreach(print)//[4,2,0,7,4]
  }


}
