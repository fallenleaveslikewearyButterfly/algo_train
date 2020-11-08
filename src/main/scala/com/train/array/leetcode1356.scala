package com.train.array

import scala.collection.mutable.Map
object leetcode1356 {

  def count1(num:Int):Int={
    var n = num
    var count = 0
    while(n>0){
      n &= n-1
      count += 1
    }
    return count
  }

  def sortByBits(arr: Array[Int]): Array[Int] = {
    var map = Map[Int,Int]()
    for(index<-Range(0,arr.length)){
      map(arr(index)) = count1(arr(index))
    }

    arr.sortWith((x,y)=>{
      if(map(x) > map(y)){
        false
      }else if(map(x) < map(y)){
        true
      }else{
        x<y
      }
    })
  }

  def main(args: Array[String]): Unit = {
    val r1 = sortByBits(Array(0,1,2,3,4,5,6,7,8))
    val r2 = sortByBits(Array(10000,10000))
    val r3 = sortByBits(Array(2,3,5,7,11,13,17,19))
    val r4 = sortByBits(Array(10,100,1000,10000))
  }
}
