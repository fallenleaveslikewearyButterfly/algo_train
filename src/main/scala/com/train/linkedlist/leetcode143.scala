package com.train.linkedlist

object leetcode143 {

  def middleNode(head: ListNode):ListNode={
    var current = head
    var slow:ListNode = current
    var fast:ListNode = current

    //快慢指针先找到中间节点
    while(fast.next!=null && fast.next.next!=null){
      slow = slow.next
      fast = fast.next.next
    }
    slow
  }

  def reverseList(head: ListNode):ListNode={
    var pre:ListNode = null
    var current = head
    var t:ListNode = null
    while(current!=null){
      t = current.next
      current.next = pre
      pre = current
      current = t
    }
    pre
  }

  def reorderList(head: ListNode): Unit = {
    if(head==null || head.next == null || head.next.next == null){
      return
    }
    var head1 = head

    val mid = middleNode(head)
    var head2 = mid.next
    mid.next=null
    head2 = reverseList(head2)

    while(head1!=null && head2!=null){
      val t1 = head1.next
      val t2 = head2.next
      head1.next=head2
      head2.next=t1
      head1 = t1
      head2 = t2
    }

  }

  def main(args: Array[String]): Unit = {
    val head1 = LinkListHelper.mkLinkList(Array(1,2,3,4))
    val head2 = LinkListHelper.mkLinkList(Array(1,2,3,4,5))
    reorderList(head1.next)
    reorderList(head2.next)
    LinkListHelper.printLinkedList(head1)
    println()
    LinkListHelper.printLinkedList(head2)
  }

}
