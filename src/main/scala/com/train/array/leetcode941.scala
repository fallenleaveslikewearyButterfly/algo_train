package com.train.array


// 另一条思路：双指针前后夹
//

object leetcode941 {
  def validMountainArray(A: Array[Int]): Boolean = {
    if(A.length==0){
      return false
    }
    var t = A(0)
    var isMax = false
    var flagleft = false
    for(i<-Range(1,A.length)){
      if(A(i)<t && !isMax){
        isMax=true
        if(i==1)
          return false
        flagleft=true
      }
      if(isMax && A(i)>=t){
        return false
      }
      t=A(i)
    }
    if(!flagleft){
      return false
    }
    return true
  }

  def main(args: Array[String]): Unit = {
    println(validMountainArray(Array(2,1)))//false
    println(validMountainArray(Array(3,5,5)))//false
    println(validMountainArray(Array(0,3,2,1)))//true
    println(validMountainArray(Array(0,3,2,1,3)))//fasle
    println(validMountainArray(Array(1,7,9,5,4,1,2)))//false
    println(validMountainArray(Array(9,8,7,6,5,4,3,2,1,0)))//false
  }
}
