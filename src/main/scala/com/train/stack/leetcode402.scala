package com.train.stack

import scala.collection.mutable.Stack
object leetcode402 {
  def removeKdigits(num: String, k: Int): String = {
    val stack = Stack[Char]()
    var n = k
    num.foreach(c=>{
      while(!stack.isEmpty && c<stack.top && n>0){
       n-=1
       stack.pop
      }
      while(!stack.isEmpty && stack.length==1 && stack.top=='0'){
        stack.pop()
      }
      stack.push(c)
    })
    for(_<-Range(0,n)){
      stack.pop()
    }
    var flag = false
    var res = ""
    while(!stack.isEmpty){
      res = stack.pop() + res
    }
    return if(res.length!=0) res else "0"
  }

  def main(args: Array[String]): Unit = {
    //println(removeKdigits("1432219",3))
    //println(removeKdigits("10200",1))
    //println(removeKdigits("10",2))
    println(removeKdigits("9",1))
  }
}
