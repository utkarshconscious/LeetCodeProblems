package com.LinkedList;

import java.util.List;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        boolean flag = false;
        ListNode nodeOne = head;
        ListNode nodeTwo = head;
        ListNode meetNode=null;
        while (nodeOne.next != null && nodeTwo.next != null && nodeTwo.next.next != null) {
            nodeOne = nodeOne.next;
            nodeTwo = nodeTwo.next.next;
            if (nodeOne == nodeTwo) {
                meetNode= nodeOne;
                break;
            }
        }
        if(meetNode!=null){
            while (head!=meetNode){
                head.next=meetNode.next;
            }
            return meetNode;
        }
        return null;
    }

}
