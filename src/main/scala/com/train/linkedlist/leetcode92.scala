package com.train.linkedlist

object leetcode92 {
  def reverseBetween(head: ListNode, m: Int, n: Int): ListNode = {
    var pre:ListNode = null
    var cur = head
    for(_<-Range(1,m)){
      pre = cur
      cur = cur.next
    }
    val startNode = pre
    val firstChange = cur
    for(_<-Range(m,n+1)){
      val t = cur.next
      cur.next=pre
      pre=cur
      cur=t
    }
    firstChange.next = cur
    if(m!=1){
      startNode.next = pre
      return head
    }else{
      return pre
    }
  }

  def main(args: Array[String]): Unit = {
    LinkListHelper.printLinkedList(reverseBetween(LinkListHelper.mkLinkList(Array(1,2,3,4,5)).next,2,4))
    LinkListHelper.printLinkedList(reverseBetween(LinkListHelper.mkLinkList(Array(1,2,3,4,5)).next,1,4))
    LinkListHelper.printLinkedList(reverseBetween(LinkListHelper.mkLinkList(Array(5)).next,1,1))
  }
}
