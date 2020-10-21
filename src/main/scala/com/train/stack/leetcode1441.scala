package com.train.stack
import scala.collection.mutable.ArrayStack

object leetcode1441 {
  val stack = ArrayStack[String]()
  def buildArray(target: Array[Int], n: Int): List[String] = {
    stack.clear()

    var index = 1
    stack.toList.reverse
  }

  def main(args: Array[String]): Unit = {
    println(buildArray(Array(1,3),3))
  }
}
