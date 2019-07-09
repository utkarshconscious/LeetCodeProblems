package com.LinkedList;

public class RemoveNthNodeFromEndofList {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode ptrOne = head;
        for (int i = 0; i < n; i++) {
            ptrOne = ptrOne.next;
        }

        ListNode ptrTwo = head;
        ListNode prev = head;

        if (ptrOne == null)
            head = head.next;
        else {
            while (ptrOne != null) {
                prev = ptrTwo;
                ptrOne = ptrOne.next;
                ptrTwo = ptrTwo.next;
            }
        }

        prev.next = ptrTwo.next;

        return head;

    }


}
