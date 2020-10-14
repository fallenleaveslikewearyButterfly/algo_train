package com.train.leetcode.backtrace

object leetcode130 {

  val d = List((-1,0),(0,-1),(1,0),(0,1))

  def _dfs(grid: Array[Array[Char]],startX:Int,startY:Int,visited:Array[Array[Int]]): Boolean ={

    visited(startX)(startY)==1

    if(grid(startX)(startY)=='O')
      grid(startX)(startY)='A'

    for((x,y) <- d){
      val newX = startX + x
      val newY = startY + y

      if(newX >=0 && newX < grid.length && newY>=0 && newY < grid(0).length && grid(newX)(newY)=='O' && visited(newX)(newY)==0){
        _dfs(grid,newX,newY,visited)
      }
    }
    visited(startX)(startY)==0
  }

  def solve(board: Array[Array[Char]]): Unit = {

    if(board.length==0){
      return
    }
    val visited = Array.ofDim[Int](board.length,board(0).length)

    for(i <- Range(0,board.length)){
      for(j <- Range(0,board(0).length)){
        if((i==0 || j== 0 ||i == board.length-1 || j== board(0).length-1) && board(i)(j)=='O'){
          _dfs(board,i,j,visited)
        }
      }
    }
    for(i <- Range(0,board.length)){
      for(j <- Range(0,board(0).length)){
        if(board(i)(j)=='O'){
          board(i)(j)='X'
        }
        if(board(i)(j)=='A'){
          board(i)(j)='O'
        }

      }
    }
  }

  def main(args: Array[String]): Unit = {
    val boards = Array(
      Array(
        Array('X','X','X','X'),
        Array('X','O','O','X'),
        Array('X','X','O','X'),
        Array('X','O','X','X')
      )
    )
    boards.foreach(board =>{
      solve(board)
    })
    boards.foreach(board=>{})
  }
}
