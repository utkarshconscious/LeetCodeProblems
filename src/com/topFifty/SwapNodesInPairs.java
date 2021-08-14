package com.topFifty;

// Given a linked list, swap every two adjacent nodes and return its head. Y
// you must solve the problem without modifying the values in the list's nodes
// (i.e., only nodes themselves may be changed.)
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode prev = newHead;
        ListNode curr = head;
        ListNode temp;
        while (curr != null && curr.next != null) {
            temp = curr.next.next;
            prev.next = curr.next;
            prev.next.next = curr;
            curr.next = temp;
            prev = curr;
            curr = curr.next;
        }
        return newHead.next;
    }
}
