package com.train.map

import scala.collection.mutable.Set
object leetcode720 {
  def longestWord(words: Array[String]): String = {
    val set = words.toSet
    var res=""
    for(word<-words){
      var flag = true
      for(i<-Range(1,word.length)){
        if(flag && !set.contains(word.slice(0,i))){
          flag = false
        }
      }
      if(flag && word.length>res.length){
        res = word
      }
      if(flag && word.length==res.length){
        var t = false
        for(i<-Range(0,word.length) if !t){
          if(word(i)<res(i)){
            res = word
            t=true
          }else if(word(i)>res(i)){
            t = true
          }
        }
      }
    }

    return res
  }

  def main(args: Array[String]): Unit = {
    //println(longestWord(Array("w","wo","wor","worl", "world")))
    //println(longestWord(Array("a", "banana", "app", "appl", "ap", "apple", "apply")))
    println(longestWord(Array("t","ti","tig","tige","tiger","e","en","eng","engl","engli","englis","english","h","hi","his","hist","histo","histor","history")))
  }
}
