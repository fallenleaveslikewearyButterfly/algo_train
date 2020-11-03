package com.train.linkedlist

object leetcode82 {
  def deleteDuplicates(head: ListNode): ListNode = {
    val dummyHead = new ListNode()
    dummyHead.next = head
    var pre = dummyHead
    var cur = head
    while(cur!=null && cur.next!=null){
      var count = 0
      var t = cur.x
      while(cur.next!=null && cur.next.x==t){
        count +=1
        cur = cur.next
      }
      if(count!=0){
        pre.next = cur.next
        cur = cur.next
      }else{
        pre = cur
        cur = cur.next
      }
    }
    return dummyHead.next
  }

  def main(args: Array[String]): Unit = {
    LinkListHelper.printLinkedList(deleteDuplicates(LinkListHelper.mkLinkList(Array(1,2,3,3,4,4,5)).next))
    LinkListHelper.printLinkedList(deleteDuplicates(LinkListHelper.mkLinkList(Array(1,1,1,2,3)).next))
    LinkListHelper.printLinkedList(deleteDuplicates(LinkListHelper.mkLinkList(Array(1,1)).next))
  }
}
