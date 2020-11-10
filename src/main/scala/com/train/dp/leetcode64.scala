package com.train.dp

object leetcode64 {
  def minPathSum(grid: Array[Array[Int]]): Int = {

    for(i<-Range(1,grid(0).length)){
      grid(0)(i) = grid(0)(i)+grid(0)(i-1)
    }
    for(i<-Range(1,grid.length)){
      grid(i)(0) = grid(i)(0) + grid(i-1)(0)
    }

    for(i<-Range(1,grid.length)){
      for(j<-Range(1,grid(i).length)){
        if(j>=grid(i).length){
          grid(i)(j) = grid(i)(j) +grid(i)(j-1)
        }
        grid(i)(j) = Math.min(grid(i)(j) + grid(i)(j-1),grid(i)(j) + grid(i-1)(j))
      }
    }
    return grid(grid.length-1)(grid(grid.length-1).length-1)
  }

  def main(args: Array[String]): Unit = {

    println(minPathSum(Array(
        Array(1,3,1),
        Array(1,5,1),
        Array(4,2,1)
      )
    ))
  }
}
