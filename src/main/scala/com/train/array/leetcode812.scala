package com.train.array

object leetcode812 {


  def largestTriangleArea(points: Array[Array[Int]]): Double = {
    var res = 0.0
    for(i<-Range(0,points.length)){
      for(j<-Range(i+1,points.length)){
        for(k<-Range(j+1,points.length)){
          res = Math.max(res, 0.5 * Math.abs(points(i)(0) * points(j)(1) + points(i)(1) * points(k)(0) + points(j)(0) * points(k)(1) - points(i)(0) * points(k)(1) - points(i)(1) * points(j)(0) - points(j)(1) * points(k)(0)))
        }
      }
    }
    return res
  }

  def main(args: Array[String]): Unit = {

    println(largestTriangleArea(Array(Array(0,0),
      Array(0,1),Array(1,0),Array(0,2),Array(2,0)))
    )
  }
}
