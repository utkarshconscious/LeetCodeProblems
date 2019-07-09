package com.LinkedList;

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {

        if (head == null) return false;
        boolean flag = false;
        ListNode nodeOne = head;
        ListNode nodeTwo = head;
        while (nodeOne.next != null && nodeTwo.next != null && nodeTwo.next.next != null) {
            nodeOne = nodeOne.next;
            nodeTwo = nodeTwo.next.next;
            if (nodeOne == nodeTwo) {
                flag = true;
                break;
            }
        }
        return flag;

    }

    public static void main(String[] args) {


    }

}


// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
