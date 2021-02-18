package com.train.array

object leetcode888 {
  def fairCandySwap(A: Array[Int], B: Array[Int]): Array[Int] = {
    val g = A.sum - B.sum
    for(x<-A){
      for(y<-B){
        if((x-y)*2 == g){
          return Array(x,y)
        }
      }
    }
    return Array()
  }

  def main(args: Array[String]): Unit = {
    println(fairCandySwap(Array(1,1),Array(2,2)).foreach(print))//   [1,2]
    println(fairCandySwap(Array(1,2),Array(2,3)).foreach(print))//   [1,2]
    println(fairCandySwap(Array(2),Array(1,3)).foreach(print))//     [2,3]
    println(fairCandySwap(Array(1,2,5),Array(2,4)).foreach(print))// [5,4]
  }

}
