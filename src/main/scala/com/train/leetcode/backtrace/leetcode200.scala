package com.train.leetcode.backtrace

object leetcode200 {

  val d = List((-1,0),(0,-1),(1,0),(0,1))

  def _dfs(grid: Array[Array[Char]],startX:Int,startY:Int,visited:Array[Array[Int]]): Boolean ={
    if(grid(startX)(startY)=='1')
      visited(startX)(startY)=1
    for((x,y) <- d){
      val newX = startX + x
      val newY = startY + y

      if(newX >=0 && newX < grid.length && newY>=0 && newY < grid(0).length && grid(startX)(startY)=='1' && visited(newX)(newY)==0){
        _dfs(grid,newX,newY,visited)
      }
    }
    return true
  }

  def numIslands(grid: Array[Array[Char]]): Int = {
    var count = 0
    if(grid.length==0){
      return count
    }
    val visited = Array.ofDim[Int](grid.length,grid(0).length)
    for(i <- Range(0,grid.length)){
      for(j <- Range(0,grid(0).length)){
        if(grid(i)(j)=='1' && visited(i)(j)==0 && _dfs(grid,i,j,visited))
          count = count + 1
      }
    }
    count
  }

  def main(args: Array[String]): Unit = {
    val grids = Array(Array(
      Array('1','1','1','1','0'),
      Array('1','1','0','1','0'),
      Array('1','1','0','0','0'),
      Array('0','0','0','0','0')
    ),Array(
      Array('1','1','0','0','0'),
      Array('1','1','0','0','0'),
      Array('0','0','1','0','0'),
      Array('0','0','0','1','1')
      )
    )
    grids.foreach(grid =>{
      println(numIslands(grid))
    })

  }

}
