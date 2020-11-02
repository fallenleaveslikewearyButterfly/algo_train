package com.train.linkedlist

object leetcode82 {
  def deleteDuplicates(head: ListNode): ListNode = {
    var pre:ListNode = null
    var cur = head
    while(cur!=null && cur.next!=null){

    }
    return head
  }

  def main(args: Array[String]): Unit = {
    LinkListHelper.printLinkedList(deleteDuplicates(LinkListHelper.mkLinkList(Array(1,2,3,3,4,4,5)).next))
    LinkListHelper.printLinkedList(deleteDuplicates(LinkListHelper.mkLinkList(Array(1,1,2)).next))
    LinkListHelper.printLinkedList(deleteDuplicates(LinkListHelper.mkLinkList(Array(1,2,2)).next))
  }
}
