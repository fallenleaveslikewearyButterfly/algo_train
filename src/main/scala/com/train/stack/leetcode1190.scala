package com.train.stack

import scala.collection.mutable.Stack
object leetcode1190 {

  val stack = Stack[String]()
  def reverseParentheses(s: String): String = {
    stack.clear()
    stack.push("")
    s.foreach(c=>{
      if(c=='('){
        stack.push("")
      }else if(c==')'){
        stack.push(stack.pop.reverse+stack.pop)
      }else{
        if(stack.isEmpty){
          stack.push(c.toString)
        }else{
          stack.push(c+stack.pop())
        }

      }
    }
    )
    stack.pop().reverse
  }

  def main(args: Array[String]): Unit = {
    println(reverseParentheses("(abcd)"))//dcba
    println(reverseParentheses("(u(love)i)"))//iloveu
    println(reverseParentheses("(ed(et(oc))el)"))//leetcode
    println(reverseParentheses("a(bcdefghijkl(mno)p)q"))//apmnolkjihgfedcbq
  }
}
