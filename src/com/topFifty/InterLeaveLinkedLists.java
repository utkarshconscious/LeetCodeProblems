package com.topFifty;

public class InterLeaveLinkedLists {

    public static ListNode interLeave(ListNode headOne, ListNode headTwo) {
        ListNode nodeOne = headOne;
        ListNode nodeTwo = headTwo;
        ListNode temp = nodeOne;
        while (nodeOne != null && nodeTwo != null) {
            temp = nodeTwo.next;
            nodeTwo.next = nodeOne.next;
            nodeOne.next = nodeTwo;
            nodeTwo = temp;
            temp = nodeOne.next;
            nodeOne = nodeOne.next.next;
        }
        if (nodeTwo != null && temp != null) {
            temp.next = nodeTwo;
        }
        return headOne;
    }

    public static void main(String[] args) {
        ListNode headOne = new ListNode(1);
              headOne.next = new ListNode(3);
              headOne.next.next = new ListNode(5);

        ListNode headTwo = new ListNode(2);
   //     headTwo.next = new ListNode(4);
 //       headTwo.next.next = new ListNode(6);
        headOne = interLeave(headOne, headTwo);
        while (headOne != null) {
            System.out.print(headOne.val);
            System.out.print(" ");
            headOne = headOne.next;
        }
    }
}
