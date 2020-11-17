package com.train.array

object leetcode1030 {
  def allCellsDistOrder(R: Int, C: Int, r0: Int, c0: Int): Array[Array[Int]] = {
    val res = Array.fill(R*C)(Array(0,0))
    for(i<-Range(0,R)){
      for(j<-Range(0,C)){
        res(C*i+j) = Array(i,j)
      }
    }
    return res.sortWith((a,b)=>(Math.abs(a(0)-r0) + Math.abs(a(1)-c0)) < (Math.abs(b(0)-r0) + Math.abs(b(1)-c0)))
  }

  def main(args: Array[String]): Unit = {
    val res1 = allCellsDistOrder(1,2,0,0)//[[0,0],[0,1]]
    val res2 = allCellsDistOrder(2,2,0,1)//[[0,1],[0,0],[1,1],[1,0]]
    val res3 = allCellsDistOrder(2,3,1,2)//[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
    println("")
  }
}
