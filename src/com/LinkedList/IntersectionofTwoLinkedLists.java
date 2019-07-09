package com.LinkedList;

public class IntersectionofTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int i = 0, j = 0;
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA.next != null) {
            nodeA = nodeA.next;
            i++;
        }
        while (nodeB.next != null) {
            nodeB = nodeB.next;
            j++;
        }
        if (i > j) {
            nodeA = headA;
            for (int k = 0; k < i - j; k++)
                nodeA = nodeA.next;
        } else {
            nodeB = headB;
            for (int k = 0; k < i - j; k++)
                nodeB = nodeB.next;
        }
        while (nodeA != null && nodeB != null) {
            if (nodeA.val == nodeB.val)
                return nodeA;
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        System.out.println(nodeA.val);
        return null;

    }


}
