package com.train.stack

import scala.collection.mutable.Stack
object leetcode1021 {



  def removeOuterParentheses(S: String): String = {
    val stack  = Stack[Char]()
    var count = 0
    var res = ""
    S.foreach(c=>{
      if(c=='('){
        count +=1
        stack.push('(')
      }else{
        count -=1
        if(count==0){
          var t = ""
          while(stack.length!=1){
            t = stack.pop + t
          }
          res += t
          stack.pop()
        }else{
          stack.push(')')
        }
      }
    })
    return res
  }

  def main(args: Array[String]): Unit = {
    println(removeOuterParentheses("(()())(())"))//()()()
    println(removeOuterParentheses("(()())(())(()(()))"))//()()()()(())
    println(removeOuterParentheses("()()"))//
  }
}
