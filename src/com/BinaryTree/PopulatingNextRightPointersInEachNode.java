package com.BinaryTree;

import java.util.*;

public class PopulatingNextRightPointersInEachNode {

    public Node connect(Node root) {

        Queue<Node> queue = new LinkedList<>();
        if(root==null)
            return null;
        queue.add(root);
        Node prev = null;
        while (!queue.isEmpty()){
            int i =0;
            prev=null;
            int size = queue.size();
            while(i<size){
                Node temp = queue.poll();
                if(prev==null){
                    prev=temp;
                }
                else{
                    prev.next=temp;
                    prev=prev.next;
                }
                if(temp.right!=null && temp.left!=null) {
                    queue.add(temp.left);
                    queue.add(temp.right);
                }
                i++;
            }
        }
        return root;
    }

}

 class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};