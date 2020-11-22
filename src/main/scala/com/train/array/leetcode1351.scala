package com.train.array

object leetcode1351 {

  def countNegatives(grid: Array[Array[Int]]): Int = {
    var res = 0
    for(i<-Range(0,grid.length)){
      var j = 0
      while(j<grid(i).length && grid(i)(j)>=0){
        j+=1
      }
      res += grid(i).length-j
    }
    return res
  }

  def main(args: Array[String]): Unit = {
    println(countNegatives(
      Array(Array(4,3,2,-1),
      Array(3,2,1,-1),
      Array(1,1,-1,-2),
      Array(-1,-1,-2,-3)
    )))//8
    println(countNegatives(
      Array(Array(3,2),
        Array(1,0)
      )))//0
  }
}
