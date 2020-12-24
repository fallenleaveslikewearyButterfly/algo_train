package com.train.Greedy

object leetcode605 {
  def canPlaceFlowers(flowerbed: Array[Int], n: Int): Boolean = {
    var count = 0
    for(i<-Range(0,flowerbed.length)){
      if(flowerbed(i)==0 &&( i==0 || flowerbed(i-1)==0) &&(i==flowerbed.length-1||flowerbed(i+1)==0) ){
        flowerbed(i)=1
        count += 1
      }
    }
    return count>=n
  }

  def main(args: Array[String]): Unit = {
    println(canPlaceFlowers(Array(0,0,0,0,0),4))//False
    println(canPlaceFlowers(Array(1,0,0,0,1),1))//True
    println(canPlaceFlowers(Array(1,0,0,0,1),2))//False
    println(canPlaceFlowers(Array(1,0,0,0,0,1),2))//False
  }
}
