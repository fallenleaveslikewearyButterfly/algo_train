package com.train.Greedy

object leetcode135 {
  def candy(ratings: Array[Int]): Int = {
    val res = Array.fill(ratings.length)(1)
    for(i<-Range(1,ratings.length)){
      if(ratings(i)>ratings(i-1) && res(i)<=res(i-1)){
        res(i) = res(i-1) + 1
      }
    }
    for(i<-Range(ratings.length-2,-1,-1)){
      if(ratings(i)>ratings(i+1) && res(i)<=res(i+1)){
        res(i) = res(i+1)+1
      }
    }
    return res.sum
  }

  def main(args: Array[String]): Unit = {
    println(candy(Array(1,0,2)))//5
    println(candy(Array(1,2,2)))//4
  }
}
