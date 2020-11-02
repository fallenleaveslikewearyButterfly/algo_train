package com.train.linkedlist

import scala.collection.mutable.Stack
object leetcode445 {
  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    val stack1 = Stack[Int]()
    val stack2 = Stack[Int]()
    var head1 = l1
    var head2 = l2
    while(head1!=null){
      stack1.push(head1.x)
      head1 = head1.next
    }
    while(head2!=null){
      stack2.push(head2.x)
      head2 = head2.next
    }
    var flag = 0
    var head:ListNode = null
    while(!stack1.isEmpty && !stack2.isEmpty){
      var t = stack1.pop()+stack2.pop()
      if(flag==0) t=t else t=t+1
      if(t>9){flag=1;t=t-10}else{flag=0}
      val tNode = new ListNode(t)
      tNode.next=head
      head = tNode
    }
    while(!stack1.isEmpty){
      var t = stack1.pop()
      if(flag==0) t=t else t=t+1
      if(t>9){flag=1;t=t-10}else{flag=0}
      val tNode = new ListNode(t)
      tNode.next=head
      head = tNode
    }
    while(!stack2.isEmpty){
      var t = stack2.pop()
      if(flag==0) t=t else t=t+1
      if(t>9){flag=1;t=t-10}else{flag=0}
      val tNode = new ListNode(t)
      tNode.next=head
      head = tNode
    }
    if(flag==1){
      val tNode = new ListNode(1)
      tNode.next=head
      head = tNode
    }
    return head
  }

  def main(args: Array[String]): Unit = {

    LinkListHelper.printLinkedList(addTwoNumbers(LinkListHelper.mkLinkList(Array(7,2,4,3)).next,LinkListHelper.mkLinkList(Array(5,6,4)).next))
    LinkListHelper.printLinkedList(addTwoNumbers(LinkListHelper.mkLinkList(Array(5)).next,LinkListHelper.mkLinkList(Array(5)).next))

  }
}
