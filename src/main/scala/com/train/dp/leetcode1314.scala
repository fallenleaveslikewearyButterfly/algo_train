package com.train.dp

object leetcode1314 {

  def calculate(mat: Array[Array[Int]],startX:Int,startY:Int,endX:Int,endY:Int):Int={
    var sum = 0
    for(i<-Range(startX,endX+1)){
      for(j<-Range(startY,endY+1)){
        sum+=mat(i)(j)
      }
    }
    return sum
  }

  def matrixBlockSum(mat: Array[Array[Int]], K: Int): Array[Array[Int]] = {
    val res = Array.ofDim[Int](mat.length,mat(0).length)
    for(i<-Range(0,mat.length)){
      for(j<-Range(0,mat(0).length)){
        var startX = if(i-K<0) 0 else i-K
        var endX = if(i+K<=mat.length-1) i+K else mat.length-1
        var startY= if(j-K<0) 0 else j-K
        var endY = if(j+K<=mat(0).length-1) j+K else mat(0).length-1
        res(i)(j) = calculate(mat,startX,startY,endX,endY)
      }
    }
    return res
  }

  def main(args: Array[String]): Unit = {
    val res = matrixBlockSum(Array(
      Array(67,64,78),
      Array(67,64,78),
      Array(82,46,46),
      Array(6,52,55),
      Array(55,99,45)
    ),3)
  }
}
