package com.train.leetcode.backtrace

object leetcode37 {

  val d = List('1','2','3','4','5','6','7','8','9')
  val visited = scala.collection.mutable.Set[Char]()

  def check(board: Array[Array[Char]],m:Int,n:Int): Boolean = {
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
    for(i<-Range(0,9) if board(m)(i)!='.'){
      val item = board(m)(i)
      if(visited.contains(item)){
        return false
      }else{
        visited.add(item)
      }
    }
    visited.clear()
    for(i<-Range(0,9) if board(i)(n)!='.'){
      val item = board(i)(n)
      if(visited.contains(item)){
        return false
      }else{
        visited.add(item)
      }
    }
    return true
  }


  def _solve(board: Array[Array[Char]],x:Int,y:Int): Boolean ={
    for(i<-Range(0,9)){
      for(j<-Range(0,9)){
        if(board(i)(j)=='.'){
          for(k<-d){
            board(i)(j)=k
            if(check(board,i,j) && _solve(board,i,j))
              return true
            board(i)(j)='.'
          }
          return false
        }
      }
    }
    return true
  }

  def solveSudoku(board: Array[Array[Char]]): Unit = {
    _solve(board,0,0)
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
      Array('.','.','.','.','8','.','.','7','.')
    )

    solveSudoku(board)
    for(i<-Range(0,9)){
      for(j<-Range(0,9)){
        print(board(i)(j)+" , ")
      }
      println()
    }
  }
}
