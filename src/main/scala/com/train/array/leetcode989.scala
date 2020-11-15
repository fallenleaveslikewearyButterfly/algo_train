package com.train.array

import scala.collection.mutable.Stack
object leetcode989 {
  def addToArrayForm(A: Array[Int], K: Int): List[Int] = {
    var stack = Stack[Int]()
    var index = A.length-1
    var t = K
    var flag = false
    while(t>0 && index>=0){
      var data = t%10
      var r = data + A(index)
      if(flag){
        r += 1
        flag=false
      }
      if(r>=10){
         r -= 10
        flag=true
      }
      stack.push(r)
      index -= 1
      t /=10
    }
    while(index>=0){
      var r = A(index)
      if(flag){
        r += 1
        flag=false
      }
      if(r>=10){
        r -= 10
        flag=true
      }
      stack.push(r)
      index -= 1
    }
    while(t>0){
      var r = t%10
      if(flag){
        r += 1
        flag=false
      }
      if(r>=10){
        r -= 10
        flag=true
      }
      stack.push(r)
      t /=10
    }
    if(flag){
      stack.push(1)
      flag=false
    }

    return stack.toList

  }

  def main(args: Array[String]): Unit = {
    //addToArrayForm(Array(1,2,0,0),34).foreach(println)//[1,2,3,4]
    //addToArrayForm(Array(2,7,4),181).foreach(println)//[4,5,5]
    //addToArrayForm(Array(2,7,4),1812).foreach(println)//[2,0,8,6]
    addToArrayForm(Array(9,9,9,9,9,9,9,9,9,9),1).foreach(println)//[1,0,0,0,0,0,0,0,0,0,0]
  }
}
