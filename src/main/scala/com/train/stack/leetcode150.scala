package com.train.stack

import scala.collection.mutable.ArrayStack
object leetcode150 {

  val stack = ArrayStack[Int]()
  def evalRPN(tokens: Array[String]): Int = {
    stack.clear()
    tokens.foreach(c=>{
      c match {
        case "+" => { val x = stack.pop();val y = stack.pop();stack.push(y+x)}
        case "-" => { val x = stack.pop();val y = stack.pop();stack.push(y-x)}
        case "*" => { val x = stack.pop();val y = stack.pop();stack.push(y*x)}
        case "/" => { val x = stack.pop();val y = stack.pop();stack.push(y/x)}
        case _ => stack.push(c.toInt)
      }
    })
    stack.top
  }

  def main(args: Array[String]): Unit = {
    println(evalRPN(Array("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+")))
  }

}
