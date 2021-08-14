package com.topFifty;
//devanaka4
//devanakaamulya
public class RotateLinkedList {
    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return head;
        }
        int length = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            length++;
        }
        k = k % length;
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        for (int i = 0; i < k; i++) {
            fastPtr = fastPtr.next;
        }
        while (fastPtr.next != null) {
            fastPtr = fastPtr.next;
            slowPtr = slowPtr.next;
        }
        fastPtr.next = head;
        head = slowPtr.next;
        slowPtr.next = null;
        return head;
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.name"));
        ListNode head = new ListNode(1);
        ListNode node = rotateRight(head, 0);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

    }


}
