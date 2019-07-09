package com.LinkedList;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode node = head;
        ListNode oldHead = null;
        while(node.next!=null){
            oldHead=head;
            head=node.next;
            node.next=head.next;
            head.next=oldHead;
        }

        return head;
    }

    public ListNode reverseListRecursion(ListNode head){

        if(head==null || head.next==null)
            return head;
        ListNode newHead = reverseListRecursion(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;

    }
}
