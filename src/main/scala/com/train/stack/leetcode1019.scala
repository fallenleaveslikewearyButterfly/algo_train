package com.train.stack

import scala.collection.mutable.ListBuffer

class ListNode(var _x: Int = 0) {
 var next: ListNode = null
 var x: Int = _x
}

object leetcode1019 {

  def nextLargerNodes(head: ListNode): Array[Int] = {
    val res = ListBuffer[Int]()

    var current = head
    while(current != null){
      var t=current
      while(t !=null && t.x<=current.x){
        t=t.next
      }
      if(t!=null){
        res.append(t._x)
      }else{
        res.append(0)
      }
      current = current.next
    }
    res.toArray
  }

  def main(args: Array[String]): Unit = {
    val head = new ListNode(2)
    head.next = new ListNode(1)
    head.next.next = new ListNode(5)
    //head.next.next.next = new ListNode(1)
   // head.next.next.next.next = new ListNode(9)
    //head.next.next.next.next.next = new ListNode(2)
    //head.next.next.next.next.next.next = new ListNode(5)
    //head.next.next.next.next.next.next.next = new ListNode(1)
    println(nextLargerNodes(head))
  }


}
