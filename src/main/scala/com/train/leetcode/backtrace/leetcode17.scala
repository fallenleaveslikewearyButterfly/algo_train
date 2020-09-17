package com.train.leetcode.backtrace

import scala.collection.mutable.ListBuffer

object leetcode17 {

  import scala.collection.mutable.ListBuffer

  private def _letterCombinations(digits: String,map:Map[Char,String]):ListBuffer[String]={
    val res = ListBuffer[String]()
    if(digits.length==1){
      map.getOrElse(digits(0),"").foreach(char=>{
        res += char.toString
      })
      res
    }else if(digits.length==0){
      res
    }
    else{
      val c = digits(0)
      val rr = this._letterCombinations(digits.slice(1,digits.length),map)
      println(c,rr)
      for(selectChar <- map.getOrElse(c,"")){
        for(t <- rr){
          println(c,selectChar,t)
          res += selectChar.toString+t
        }
      }
      res
    }
  }
  def letterCombinations(digits: String): List[String] = {
    val map=Map('2'->"abc",'3'->"def",'4'->"ghi",'5'->"jkl",'6'->"mno",'7'->"pqrs",'8'->"tuv",'9'->"wxyz")
    this._letterCombinations(digits,map).toList
  }

  def main(args: Array[String]): Unit = {
    val res = letterCombinations("234")
    print(res)
  }
}
