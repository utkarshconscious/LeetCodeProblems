package com.LinkedList;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode node = head;


        if (l1 == null && l2 == null)
            return null;
        else if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;

        while (l1 != null && l2 != null) {

            if(l1.val > l2.val){
                node.next=l2;
                l2=l2.next;
            }
            else{
                node.next=l1;
                l1=l1.next;
            }
            node=node.next;
        }

        while (l1 != null) {
            node.next = l1;
            node = node.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            node.next = l2;
            node = node.next;
            l2 = l2.next;
        }


        return head.next;
    }

    public static void main (String [] args){
        ListNode head = new ListNode(1);
        head.next=new ListNode(2);
        head.next.next= new ListNode(4);

        ListNode head2 = new ListNode(1);
        head2.next=new ListNode(3);
        head2.next.next= new ListNode(4);

       ListNode output = new MergeTwoSortedLists().mergeTwoLists(head,head2);
       while (output!=null){
           System.out.println(output.val);
           output=output.next;
       }
    }


}
