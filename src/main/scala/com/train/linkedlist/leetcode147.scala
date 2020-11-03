package com.train.linkedlist

object leetcode47 {
  def insertionSortList(head: ListNode): ListNode = {
    var dummyHead = new ListNode()
    dummyHead.next=head
    if(head==null){
      return head
    }
    var l1tail = head
    var l2 = head.next
    head.next = null

    while(l2!=null){
      if(l2.x<l1tail.x){
        var pre = dummyHead
        var cur = dummyHead.next
        while(cur.x<=l2.x){
          pre = cur
          cur = cur.next
        }
        var t=l2.next
        pre.next = l2
        l2.next = cur
        l2=t
      }else{
        l1tail.next=l2
        l2 = l2.next
        l1tail=l1tail.next
        l1tail.next=null
      }

    }
    return dummyHead.next
  }

  def main(args: Array[String]): Unit = {
    LinkListHelper.printLinkedList(insertionSortList(LinkListHelper.mkLinkList(Array(2,4,5,4)).next))
    LinkListHelper.printLinkedList(insertionSortList(LinkListHelper.mkLinkList(Array(4,2,1,3)).next))
    LinkListHelper.printLinkedList(insertionSortList(LinkListHelper.mkLinkList(Array(-1,5,3,4,0)).next))
  }
}
