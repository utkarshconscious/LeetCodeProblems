package com.LinkedList;

public class FlattenAMultilevelDoublyLinkedList {

    public Node flatten(Node head) {
        Node node = head;

        while (node!=null)
        {if(node.child==null){
            node=node.next;
            continue;
        }
            Node hold = node.next;
            Node child = node.child;
            node.child=null;
            Node prev = node;
            while (child!=null){
                child.prev=node;
                node.next=child;

                child=child.next;
                node=node.next;
            }
            if(hold!=null)
                hold.prev=node;
            node.next=hold;
            node = prev.next;
        }

        return head;

    }


}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {
    }

    public Node(int _val, Node _prev, Node _next, Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};