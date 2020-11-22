package com.train.array

object leetcode1252 {
  def oddCells(n: Int, m: Int, indices: Array[Array[Int]]): Int = {
    val rows = Array.fill(n)(0)
    val cols = Array.fill(m)(0)

    indices.foreach(item=>{
      rows(item(0)) += 1
      cols(item(1)) += 1
    })
    var odd_rows = 0
    var odd_cols = 0

    rows.foreach(x=>{
      if(x%2==1){
        odd_rows+=1
      }
    })
    cols.foreach(x=>{
      if(x%2==1){
        odd_cols+=1
      }
    })
    return odd_rows*(m-odd_cols)+(n-odd_rows)*odd_cols
  }

  def main(args: Array[String]): Unit = {
    println(oddCells(2,3,Array(Array(0,1),Array(1,1))))
  }
}
