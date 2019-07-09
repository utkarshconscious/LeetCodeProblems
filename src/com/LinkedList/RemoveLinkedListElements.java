package com.LinkedList;

public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return null;
        }
        while(head!=null && head.val==val){
            head=head.next;
           // return head;
        }

            ListNode node = head;
            while(node!=null && node.next!=null){
                if(node.next.val==val){

                    node.next=node.next.next;
                    continue;
                   // return head;
                }
                node=node.next;
            }

        return head;
    }

    public ListNode removeElementsCopied(ListNode head, int val) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode curr = head, prev = fakeHead;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }
            curr = curr.next;
        }
        return fakeHead.next;
    }


}
