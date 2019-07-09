package com.LinkedList;

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {

        if(head==null)
            return true;
        if(head.next==null)
            return true;
        ListNode one = head;
        ListNode two = head;
        if(head.next.next==null){
            if(head.val!=head.next.val)
                return false;
            else
                return true;
        }

        while(two!=null && two.next!=null){
            one=one.next;
            two=two.next.next;

        }
        ListNode mid= reverseList(one);
        ListNode node = head;
        while(mid!=null){
            if(node.val!=mid.val)
                return false;
            node=node.next;
            mid=mid.next;
        }

        return true;

    }
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
}
