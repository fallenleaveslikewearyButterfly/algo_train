package com.train.map

object leetcode463 {
  val d = List((-1,0),(0,-1),(1,0),(0,1))
  def islandPerimeter(grid: Array[Array[Int]]): Int = {
    var res = 0
    for(i<-Range(0,grid.length)){
      for(j<-Range(0,grid(0).length)){
        if(grid(i)(j) == 1){
          var t=4
          for((_x,_y) <- d){
            val newX = i+_x
            val newY = j+_y
            if(newX>=0 && newY >=0 && newX<grid.length && newY < grid(0).length && grid(newX)(newY)==1){
              t -=1
            }
          }
          res += t
        }
      }
    }
    return res
  }

  def main(args: Array[String]): Unit = {
    println(islandPerimeter(Array(
      Array(0,1,0,0),
      Array(1,1,1,0),
      Array(0,1,0,0),
      Array(1,1,0,0)
    )))

  }
}
