package com.train.stack

import scala.collection.mutable.Stack
object leetcode1249 {
  def minRemoveToMakeValid(s: String): String = {
    val stack = Stack[Int]()
    for(i<-Range(0,s.length)){
      if(s(i)=='('){
        stack.push(i)
      }else if(s(i)==')'){
        if(!stack.isEmpty && s(stack.top)=='('){
          stack.pop()
        }else{
          stack.push(i)
        }
      }
    }
    stack.clear()
    var res = ""
    for(i<-Range(s.length-1,-1,-1)){
      if(!stack.isEmpty && i==stack.top){
        stack.pop()
      }else{
        res = s(i)+res
      }
    }
    return res
  }

  def main(args: Array[String]): Unit = {
    println(minRemoveToMakeValid("lee(t(c)o)de)"))
    println(minRemoveToMakeValid("a)b(c)d"))
    println(minRemoveToMakeValid("))(("))
    println(minRemoveToMakeValid("(a(b(c)d)"))
    println(minRemoveToMakeValid("a(b)((c)d"))
  }
}
