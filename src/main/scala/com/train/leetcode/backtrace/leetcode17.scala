package com.train.leetcode.backtrace

import scala.collection.mutable.ListBuffer

object leetcode17 {

  private def _letterCombinations(digits: String,map:Map[Char,String]):ListBuffer[String]={
    val res = ListBuffer[String]()
    if(digits.length==1){

    }else{
      for(index<-Range(0,digits.length)){
        val c = digits(index)
        for(selectChar <- Range(97+(c-50)*3,97+(c-49)*3)){
          for(t <- this._letterCombinations(digits.slice(index+1,digits.length),map)){
            res.append(selectChar.toChar+t)
          }
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
    val res = letterCombinations("23")
    print(res)
  }
}
