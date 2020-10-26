package com.train.stack

import scala.collection.mutable.ListBuffer
object leetcode331 {

  val stack = ListBuffer[String]()
  def isValidSerialization(preorder: String): Boolean = {
    stack.clear()
    preorder.split(",").foreach(c=>{
      stack.append(c)
      while(stack.length>=3 && stack(stack.length-1)=="#" && stack(stack.length-2)=="#" && stack(stack.length-3)!="#"){
        stack.remove(stack.length-1)
        stack.remove(stack.length-1)
        stack.remove(stack.length-1)
        stack.append("#")
      }
    })
    return stack.length==1 && stack(0)=="#"
  }

  def main(args: Array[String]): Unit = {
    isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#")
  }
}
