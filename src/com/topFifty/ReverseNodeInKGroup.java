package com.topFifty;

public class ReverseNodeInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode prev = newHead;
        ListNode curr = head;
        ListNode temp;

        while (curr != null) {
            temp = curr;
            boolean continueReverse = true;
            // this is only to check that k elements are left to be reversed.
            for (int i = 0; i < k; i++) {
                if (temp == null) {
                    continueReverse = false;
                    break;
                }
                temp = temp.next;
            }
            if (!continueReverse) {
                break;
            }
            int i = 1;
            while (i < k) {
                i++;
                temp = curr.next.next;
                curr.next.next=prev.next;
                prev.next = curr.next;
                curr.next = temp;

            }
            prev = curr;
            curr = curr.next;
        }
        return newHead.next;
    }
}
