package com.train.stack
import scala.collection.mutable.ArrayStack

object leetcode1441 {

  val stack = ArrayStack[String]()

  def buildArray(target: Array[Int], n: Int): List[String] = {
    stack.clear()
    var targetIndex = 0

    var end  =  if(target(target.length-1)<n) target(target.length-1) else n
    for(index<-Range(1,end+1)) {
      if (target(targetIndex) == index) {
        stack.push("Push")
        targetIndex += 1
      } else {
        stack.push("Push")
        stack.push("Pop")
      }
    }

    stack.toList.reverse
  }

  def main(args: Array[String]): Unit = {
    println(buildArray(Array(2,3,4),4))
  }
}

