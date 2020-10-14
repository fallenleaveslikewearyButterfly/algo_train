package com.train.leetcode.backtrace

object leetcoce79 {
    val d = List((-1,0),(0,1),(1,0),(0,-1))

    def _exist(board: Array[Array[Char]], word: String,index:Int,startX:Int,startY:Int,visited:Array[Array[Int]]): Boolean ={
      if(index==word.length-1){
        if(board(startX)(startY)==word(index))
          return true
        else
          return false
      }
      if(board(startX)(startY)==word(index)){
        visited(startX)(startY) = 1
        for((x,y)<-d){
          val newX = startX + x
          val newY = startY + y
          if(newX>=0 && newX < board.length && newY>=0 && newY<board(0).length && visited(newX)(newY) == 0){
            if(_exist(board,word,index+1,newX,newY,visited)){
              return true
            }
          }
        }
        visited(startX)(startY) = 0
      }
      return false
    }

    def exist(board: Array[Array[Char]], word: String): Boolean = {
      val visited = Array.ofDim[Int](board.length,board(0).length)
      for(i<-Range(0,board.length)){
        for(j<-Range(0,board(i).length)){
          if(_exist(board,word,0,i,j,visited)){
            return true
          }
        }
      }
      false
    }


  def main(args: Array[String]): Unit = {
    val board = Array(Array('A','B','C','E'),
      Array('S','F','C','S'),
      Array('A','D','E','E')
    )

    val words = Array("ABCCED","SEE","ABCB")
    for(word <- words){
      println(exist(board,word))
    }

  }
}
