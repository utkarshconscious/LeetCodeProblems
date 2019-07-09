package com.LinkedList;

import java.util.List;

public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        int i = 0;
        if(head==null || head.next==null)
            return head;

        ListNode newHead = head;
        while (newHead != null) {
            i++;
            newHead = newHead.next;
        }
        k = k % i;
        if(k==0)
            return head;
        ListNode kNode = head;
        ListNode prev = null;

        for (int j = 0; j < k; j++) {
            kNode = kNode.next;
        }
        newHead = head;
        ListNode oldEnd = null;
        while (kNode != null) {
            oldEnd=kNode;
            kNode = kNode.next;
            prev = newHead;
            newHead= newHead.next;
        }
        oldEnd.next = head;
        if (prev != null)
            prev.next = null;
        return newHead;
    }

    public static void main(String [] args){
        ListNode head = new ListNode(1);
        head.next= new ListNode(2);
        head.next.next=new ListNode(3);
        /*   head.next.next.next= new ListNode(4);
*/
        ListNode output = new RotateList().rotateRight(head,10);

        while(output!=null){
            System.out.println(output.val);
            output=output.next;
        }

    }

}
