package com.LinkedList;


import java.util.ArrayList;
import java.util.List;

public class OddEvenLinkedList {


    public ListNode oddEvenList(ListNode head) {

        if(head==null || head.next==null)
            return head;

        ListNode oddHead=head;
        ListNode evenHead=head.next;
        ListNode hold =head.next;
        while (evenHead!=null && evenHead.next!=null){
            oddHead.next=evenHead.next;
            oddHead=oddHead.next;
            //  evenHead.next=oddHead.next.next;

            //   oddHead=oddHead.next;
            evenHead.next=oddHead.next;
            evenHead=evenHead.next;
        }

        oddHead.next=hold;

        return head;
    }

    public static void main (String [] args){


    }
}
