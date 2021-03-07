package com.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class CopyListwithRandomPointer {

//    public RandomListNode copyRandomList(RandomListNode head) {
//
//        if (head==null)
//            return null;
//        if (head.next==null) {
//            RandomListNode newHead=  new RandomListNode(head.label);
//                if(head.random!=null)
//                    newHead.random=newHead;
//        }
//        RandomListNode newHead = new RandomListNode(head.label);
//        Map<Integer,RandomListNode> nodeMap = new HashMap<Integer,RandomListNode>();
//        nodeMap.put(head.label,newHead);
//        if(head.random!=null){
//            newHead.random=nodeMap.get(head.random.label);
//            if(newHead.random==null){
//                RandomListNode randomNode = new RandomListNode(head.random.label);
//                newHead.random=randomNode;
//                nodeMap.put(head.random.label, randomNode);
//            }
//        }
//        RandomListNode newNode = newHead;
//        for (Map.Entry<Integer,RandomListNode> entry : nodeMap.entrySet())
//            System.out.println("Key = " + entry.getKey() +
//                    ", Value = " + entry.getValue());
//        while(head.next!=null){
//            newNode.next=nodeMap.get(head.next.label);
//            if(newNode.next==null){
//                newNode.next=new RandomListNode(head.next.label);
//                nodeMap.put(head.next.label,newNode.next);
//            }
//
//            if(head.next.random!=null) {
//                System.out.println("head.next.random not null: "+head.next.random.label);
//                RandomListNode randomNode = nodeMap.get(head.next.random.label);
//                if (randomNode == null) {
//                    System.out.println("randomNode == null ");
//                    randomNode = new RandomListNode(head.next.random.label);
//                    nodeMap.put(head.next.random.label, randomNode);
//                }
//                newNode.next.random = randomNode;
//            }
//            head=head.next;
//            newNode=newNode.next;
//        }
//
//        return newHead;
//    }

    public RandomNode copyRandomList(RandomNode head) {
        RandomNode newHead = null;
        RandomNode newStart;
        if (head == null) {
            return null;
        } else if (head.next == null) {
            newHead = new RandomNode(head.val);
            if (head.random != null) {
                newHead.random = newHead;
            }
            newStart = newHead;
        } else {
            Map<Integer, RandomNode> nodeMap = new HashMap<>();
            newHead = new RandomNode(Integer.MIN_VALUE);
            newStart = newHead;
            while (head != null) {
                if(nodeMap.containsKey(head.val)){
                    newHead.next = nodeMap.get(head.val);

                }
                else{
                    newHead.next = new RandomNode(head.val);
                    nodeMap.put(head.val,newHead.next);
                }


                nodeMap.put(head.val, newHead.next);
                if (head.random != null) {
                    nodeMap.put(head.random.val, new RandomNode(head.random.val));
                    newHead.next.random = nodeMap.get(head.random.val);
                }
                newHead = newHead.next;
                head = head.next;
            }
        }
        return newStart.next;
    }


    public static void main(String [] args){
        RandomNode randomNode = new RandomNode(1);
        RandomNode randomNode2 = new RandomNode(2);
        randomNode.next=randomNode2;
        randomNode.random=randomNode2;
        randomNode2.random=randomNode2;

        RandomNode output = new CopyListwithRandomPointer().copyRandomList(randomNode);

        RandomNode temp = output;
        while(temp!=null){
            System.out.println("temp.label: "+temp.val);

            if(temp.next!=null){
                System.out.println("temp.next: "+temp.next.val);
            }
            if(temp.random!=null){
                System.out.println("temp.random: "+temp.random.val);
            }
            temp=temp.next;
        }
    }
}
  // Definition for singly-linked list with a random pointer.
  class RandomNode {
      int val;
      RandomNode next, random;
      RandomNode(int x) { this.val = x; }
  }