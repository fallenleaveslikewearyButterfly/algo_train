package com.train.array

import scala.collection.mutable.Map

object leetcode1122 {
  def relativeSortArray(arr1: Array[Int], arr2: Array[Int]): Array[Int] = {
    val map = Map[Int,Int]()
    arr1.foreach(i=>{
      if(!map.contains(i)){
        map(i) = 0
      }
      map(i) +=1
    })
    var index = 0
    arr2.foreach(j=>{

      while(map(j)!=0){
        arr1(index) = j
        map(j) -=1
        index += 1
      }
      map.remove(j)
    })

    val r = map.keys.toArray.sorted
    for(i<-r){
      while(map(i)!=0){
        arr1(index) = i
        index += 1
        map(i) -= 1
      }
    }
    return arr1
  }

  def main(args: Array[String]): Unit = {

    val res = relativeSortArray(
      Array(2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31),
      Array(2,42,38,0,43,21))//[2,2,2,1,4,3,3,9,6,7,19]
    res.foreach(println)
  }

}
