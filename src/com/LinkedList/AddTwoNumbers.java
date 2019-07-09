package com.LinkedList;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        int carry = 0;
        int temp = 0;
        ListNode node = head;
        while (l1!=null && l2!=null){
            temp = l1.val+l2.val+carry;
            node.next=new ListNode(temp%10);
            carry=temp/10;
            node=node.next;
            l1=l1.next;
            l2=l2.next;
        }

        while (l1!=null){
            temp = l1.val+carry;
            node.next=new ListNode(temp%10);
            carry=temp/10;
            node=node.next;
            l1=l1.next;
        }

        while (l2!=null){
            temp = l2.val+carry;
            node.next=new ListNode(temp%10);
            carry=temp/10;
            node=node.next;
            l2=l2.next;
        }
        if(carry>0){
            node.next= new ListNode(carry);
        }
        return head.next;
    }

    public static void main (String [] args){
        int i =19;
        System.out.println(i/10);
    }
}
