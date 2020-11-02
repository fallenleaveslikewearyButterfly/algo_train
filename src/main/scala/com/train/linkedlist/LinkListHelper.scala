package com.train.linkedlist

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}

object LinkListHelper {
  def mkLinkList(arr:Array[Int]):ListNode={
    var current = new ListNode()
    val head = new ListNode()
    head.next=current
    for(i<-Range(0,arr.length-1)){
      current.x = arr(i)
      current.next = new ListNode()
      current=current.next
    }
    current.x = arr(arr.length-1)
    head
  }

  def printLinkedList(head:ListNode):Unit={
    print(head.x)
    var current = head.next
    while(current!=null){
      print(f"->${current.x}")
      current = current.next
    }
    println("->null")
  }

  def main(args: Array[String]): Unit = {
    val head = mkLinkList(Array(1,2,3,4,5))
    printLinkedList(head)
  }
}
