package com.train.stack

import scala.collection.mutable.Stack
object leetcode224 {

  val stack=Stack[Int]()

  def calculate(s: String): Int = {
    0
  }

  def main(args: Array[String]): Unit = {
    println(calculate("(1+(4+5+2)-3)+(6+8)"))
    println(calculate("1 + 1"))
    println(calculate("2-1 + 2"))

  }
}
