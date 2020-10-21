package com.train.stack
import scala.collection.mutable.ArrayStack

object leetcode1047 {
  val stack = ArrayStack[Char]()
  def removeDuplicates(S: String): String = {
    stack.clear()
    S.foreach(c=>{
      if(stack.isEmpty){
        stack.push(c)
      }else{
        val t = stack.top
        if(t!=c){
          stack.push(c)
        }else{
          stack.pop()
        }
      }

    })
    var res = ""
    stack.foreach(c=>{
      res  = c+res
    })
    res
  }

  def main(args: Array[String]): Unit = {
    val res = removeDuplicates("abbaca")
    print(res)
  }
}
