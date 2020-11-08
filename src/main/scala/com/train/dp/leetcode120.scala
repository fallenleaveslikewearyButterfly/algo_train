package com.train.dp

object leetcode120 {

  def minimumTotal(triangle: List[List[Int]]): Int = {
    val ss = Array.ofDim[Array[Int]](triangle.length)
    ss(0) = triangle(0).toArray
    for(i<-Range(1,triangle.length)){
      ss(i) = Array.ofDim(triangle(i).length)
      ss(i)(0) = ss(i-1)(0) + triangle(i)(0)
      ss(i)(triangle(i).length-1) = ss(i-1)(ss(i-1).length-1) + triangle(i)(triangle(i).length-1)
      for(j<-Range(1,i)){
        ss(i)(j) = Math.min(triangle(i)(j) + ss(i-1)(j),triangle(i)(j) + ss(i-1)(j-1))
      }
    }
    return ss(triangle.length-1).min
  }

  def main(args: Array[String]): Unit = {
    println(
      minimumTotal(List(
        List(2),
        List(3,4),
        List(6,5,7),
        List(4,1,8,3)
      ))
    )
  }
}
