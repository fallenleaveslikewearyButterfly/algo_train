package com.train.leetcode.backtrace

object leetcode37 {

  val d = List('1','2','3','4','5','6','7','8','9')
  val visited = scala.collection.mutable.Set[Char]()

  def check(board: Array[Array[Char]],m:Int,n:Int):Boolean = {
    visited.clear()
    val x = m/3
    val y = n/3
    for(i<-Range(3*x,3*x+3)){
      for(j<-Range(3*y,3*y+3) if board(i)(j)!='.'){
        if(visited.contains(board(i)(j))){
          return false
        }else{
          visited.add(board(i)(j))
        }
      }
    }
    visited.clear()
    for(item<-board(m) if item !='.'){
      if(visited.contains(item)){
        return false
      }else{
        visited.add(item)
      }
    }
    visited.clear()
    for(item<-board(n) if item !='.'){
      if(visited.contains(item)){
        return false
      }else{
        visited.add(item)
      }
    }
    return true
  }


  def _solve(board: Array[Array[Char]],x:Int,y:Int,visited:Array[Array[Boolean]]): Boolean ={
    if(x==8 && y==8){
      return true
    }
    if(board(x)(y)=='.'){
      for(k <-d){
        board(x)(y) = k
        if(check(board,x,y)){
          if(y+1<9){
            if(_solve(board,x,y+1,visited))
              return true
          }else if (x+1<9){
            if(_solve(board,x+1,y+1-9,visited))
              return true
          }
        }
        board(x)(y) = '.'
      }
    }else{
      if(y+1<9){
        if(_solve(board,x,y+1,visited))
          return true
      }else if (x+1<9){
        if( _solve(board,x+1,y+1-9,visited))
          return true
      }
    }
    false
  }



  def solveSudoku(board: Array[Array[Char]]): Unit = {
    val visited = Array.fill(9,9)(false)
    _solve(board,0,0,visited)
  }

  def main(args: Array[String]): Unit = {
    val board = Array(
      Array('5','3','.','.','7','.','.','.','.'),
      Array('6','.','.','1','9','5','.','.','.'),
      Array('.','9','8','.','.','.','.','6','.'),
      Array('8','.','.','.','6','.','.','.','3'),
      Array('4','.','.','8','.','3','.','.','1'),
      Array('7','.','.','.','2','.','.','.','6'),
      Array('.','6','.','.','.','.','2','8','.'),
      Array('.','.','.','4','1','9','.','.','5'),
      Array('.','.','.','.','8','.','.','7','9')
    )

    solveSudoku(board)
    for(i<-Range(0,9)){
      for(j<-Range(0,9)){
        print(board(i)(j)+",")
      }
      println()
    }
  }
}
