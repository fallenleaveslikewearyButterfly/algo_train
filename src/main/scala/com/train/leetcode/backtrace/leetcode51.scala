package com.train.leetcode.backtrace
import scala.collection.mutable.ListBuffer


object leetcode51 {
  val res = ListBuffer[List[String]]()

  def _solve(pannel:Array[Array[String]],start:Int,n:Int,visited:Array[Array[Boolean]]):Unit = {
    if(start==n){
      res.append(pannel.map(x=>{x.mkString}).toList)
    }

    for(i<-Range(0,n)){
      if(!visited(0)(i) && !visited(1)(start+i) && !visited(2)(start - i +n)){
        pannel(start)(i)="Q"
        visited(0)(i)= true
        visited(1)(start+i) =true
        visited(2)(start - i +n) = true
        _solve(pannel,start+1,n,visited)
        visited(0)(i)= false
        visited(1)(start+i) =false
        visited(2)(start - i +n) = false
        pannel(start)(i)="."
      }
    }
  }

  def solveNQueens(n: Int): List[List[String]] = {
    val pannel = Array.fill(n,n)(".")
    val visited = Array.fill(3,2*n)(false)
    res.clear()
    _solve(pannel,0,n,visited)
    res.toList
  }

  def main(args: Array[String]): Unit = {
    solveNQueens(4)
  }

}
