package com.train.stack

class NestedInteger {

    // Return true if this NestedInteger holds a single integer, rather than a nested list.
    def isInteger: Boolean = {}

    // Return the single integer that this NestedInteger holds, if it holds a single integer
    def getInteger: Int = {}

    // Set this NestedInteger to hold a single integer.
    def setInteger(i: Int) = {}

    // Return the nested list that this NestedInteger holds, if it holds a nested list
    def getList = {}

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    def add(ni: NestedInteger) = {}
  }

import scala.collection.mutable.ArrayStack
class NestedIterator(_nestedList: List[NestedInteger]) {

  val stack = ArrayStack[NestedInteger]()
  stack.toList.reverse
  for(i<-Range(_nestedList.length-1,-1,-1)){
    stack.push(_nestedList(i))
  }

  def next(): Int = {
    stack.pop.getInteger
  }

  def hasNext(): Boolean = {
    if(!stack.isEmpty && !stack.top.isInteger){
      stack.pop().getList.reverse.foreach(c=>{
        stack.push(c)
      })
    }
    return stack.length>0
  }
}

object leetcode341 {
  def main(args: Array[String]): Unit = {

  }
}
