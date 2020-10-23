package com.train.stack

import scala.collection.mutable.ArrayStack

object leetcode71 {
  val stack = ArrayStack[String]()
  def simplifyPath(path: String): String = {
    stack.clear()
    path.split("/").foreach(s=>{
      if(s=="" || s=="."){

      }else if(s==".."){
        if(!stack.isEmpty){
          stack.pop()
        }
      }else{
        stack.push(s)
      }
    })
    "/"+stack.toList.reverse.mkString("/")
  }

  def main(args: Array[String]): Unit = {

    println(simplifyPath("/../"))
  }
}
