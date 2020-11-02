package com.train.linkedlist

object leetcode86 {
  def partition(head: ListNode, x: Int): ListNode = {
    var before_head:ListNode = new ListNode() //小于3的指针
    var after_head:ListNode = new ListNode() //大于3的指针
    var before = before_head
    var after = after_head
    var cur = head
    while(cur!=null){
      if(cur.x<x){
        before.next = cur
        before = before.next
      }else{
        after.next = cur
        after = after.next
      }
      cur = cur.next
    }
    after.next = null
    before.next = after_head.next
    return before_head.next
  }

  def main(args: Array[String]): Unit = {
    LinkListHelper.printLinkedList(partition( LinkListHelper.mkLinkList(Array(1,4,3,2,5,2)).next,3))
    LinkListHelper.printLinkedList(partition( LinkListHelper.mkLinkList(Array(2,1)).next,2))
  }
}
