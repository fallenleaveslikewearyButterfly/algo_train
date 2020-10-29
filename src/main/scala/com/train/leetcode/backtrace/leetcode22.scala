package com.train.leetcode.backtrace

import scala.collection.mutable.ListBuffer

object leetcode22 {

  def _dfs(l:Int,r:Int,res:ListBuffer[String],t:String): Unit ={
    if(l==0 && r==0){
      res.append(t)
    }else{
      if(l<=r){
        if(l>0){
          _dfs(l-1,r,res,t+"(")
        }
        if(r>0){
          _dfs(l,r-1,res,t+")")
        }
      }
    }
  }

  def generateParenthesis(n: Int): List[String] = {
    val res = ListBuffer[String]()
      _dfs(3,3,res,"")
    return res.toList
  }

  def main(args: Array[String]): Unit = {
    // n = 3
    //"((()))",
    //"(()())",
    //"(())()",
    //"()(())",
    //"()()()"
    println(generateParenthesis(5))
  }

}
