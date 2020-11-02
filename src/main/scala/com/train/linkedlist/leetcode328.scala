package com.train.linkedlist

object leetcode328 {
  def oddEvenList(head: ListNode): ListNode = {

    var count = 0

    var before_head:ListNode = new ListNode() //小于3的指针
    var after_head:ListNode = new ListNode() //大于3的指针
    var before = before_head
    var after = after_head
    var cur = head
    while(cur!=null){
      count+=1
      if(count%2==1){
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
    LinkListHelper.printLinkedList(oddEvenList(LinkListHelper.mkLinkList(Array(1,2,3,4,5)).next))
    LinkListHelper.printLinkedList(oddEvenList(LinkListHelper.mkLinkList(Array(2,1,3,5,6,4,7)).next))
  }
}
