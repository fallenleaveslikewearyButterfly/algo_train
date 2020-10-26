package com.train.stack

import scala.collection.mutable.Stack

object leetcode856 {

  val stack = Stack[Char]()

  def scoreOfParentheses(S: String): Int = {
    stack.clear()
    var score = 0
    for(i<-Range(0,S.length)){
      if(S(i)=='('){
        stack.push('(')
      }else{
        if(S(i-1)=='('){
          stack.pop()
          score += (1<<stack.length)
        }else{
          stack.pop()
        }
      }
    }
    score
  }

  def main(args: Array[String]): Unit = {
    println(scoreOfParentheses("(()(()))"))
    println(scoreOfParentheses("()()"))
    println(scoreOfParentheses("(())"))
  }
}
