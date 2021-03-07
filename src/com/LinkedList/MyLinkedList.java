package com.LinkedList;

public class MyLinkedList {
    private Node head = new Node();
    private  int height=0;
    class Node {
        int value;
        Node next;

        public Node(){

        }
        public Node(int value){
            this.value=value;
        }
    }
    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(head.next==null)
        return -1;
        Node node = head;
        for(int i=0;i<=index;i++){
            if(node.next==null)
                return -1;
            else {
                node = node.next;
            }
        }
        return node.value;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node(val);
        if(head.next==null)
            head.next=node;
        else{
            node.next=head.next;
            head.next=node;
        }
        height++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        System.out.println("at tail");
        if(head.next==null) {
            head.next = new Node(val);

        }
        else {
            Node node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node(val);
        }
        height++;

    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index==height)
            addAtTail(val);
        else {
            Node node = head;
            Node prev = null;
            for (int i = 0; i <= index; i++) {
                if (node.next == null)
                    
                    return;
                else {
                    prev = node;
                    node = node.next;
                }
            }
            Node newNode = new Node(val);
            newNode.next = node;
            prev.next = newNode;
            height++;
        }

    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(head.next==null)
            return;
        Node node = head;
        Node prev = null;
        for(int i=0;i<=index;i++){
            if(node.next==null)
                return;
            else {
                prev=node;
                node = node.next;
            }
        }
        prev.next=node.next;
        height--;
    }

    public static void main(String [] args){
       /* MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        System.out.println(myLinkedList.get(0)+" "+myLinkedList.get(1));
        myLinkedList.addAtIndex(1,2);
        System.out.println(myLinkedList.get(0)+" "+myLinkedList.get(1)+" "+myLinkedList.get(2));
        myLinkedList.deleteAtIndex(1);
        System.out.println(myLinkedList.get(1));
        myLinkedList.addAtHead(4);
        System.out.println(myLinkedList.get(0)+" "+myLinkedList.get(1)+" "+myLinkedList.get(2));
        myLinkedList.addAtIndex(1,2);
        System.out.println(myLinkedList.get(0)+" "+myLinkedList.get(1)+" "+myLinkedList.get(2)+" "+myLinkedList.get(3));*/
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        System.out.println(myLinkedList.get(1)+" "+myLinkedList.get(0)+" "+myLinkedList.get(2));
        myLinkedList.addAtIndex(1,2);
        System.out.println(myLinkedList.get(1)+" "+myLinkedList.get(0)+" "+myLinkedList.get(2));

        System.out.println("---------------------------------------------------------");
        MyLinkedList myLinkedList1 = new MyLinkedList();
        System.out.println(myLinkedList1.get(0));
        myLinkedList1.addAtIndex(1,2);
        System.out.println(myLinkedList1.get(0));
        System.out.println(myLinkedList1.get(1));
        myLinkedList1.addAtIndex(0,1);
        System.out.println(myLinkedList1.get(0));
        System.out.println(myLinkedList1.get(1));


    }
}
