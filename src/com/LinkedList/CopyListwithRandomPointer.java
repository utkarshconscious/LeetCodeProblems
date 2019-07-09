package com.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class CopyListwithRandomPointer {

    public RandomListNode copyRandomList(RandomListNode head) {

        if (head==null)
            return null;
        if (head.next==null) {
            RandomListNode newHead=  new RandomListNode(head.label);
                if(head.random!=null)
                    newHead.random=newHead;
        }
        RandomListNode newHead = new RandomListNode(head.label);
        Map<Integer,RandomListNode> nodeMap = new HashMap<Integer,RandomListNode>();
        nodeMap.put(head.label,newHead);
        if(head.random!=null){
            newHead.random=nodeMap.get(head.random.label);
            if(newHead.random==null){
                RandomListNode randomNode = new RandomListNode(head.random.label);
                newHead.random=randomNode;
                nodeMap.put(head.random.label, randomNode);
            }
        }
        RandomListNode newNode = newHead;
        for (Map.Entry<Integer,RandomListNode> entry : nodeMap.entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
        while(head.next!=null){
            newNode.next=nodeMap.get(head.next.label);
            if(newNode.next==null){
                newNode.next=new RandomListNode(head.next.label);
                nodeMap.put(head.next.label,newNode.next);
            }

            if(head.next.random!=null) {
                System.out.println("head.next.random not null: "+head.next.random.label);
                RandomListNode randomNode = nodeMap.get(head.next.random.label);
                if (randomNode == null) {
                    System.out.println("randomNode == null ");
                    randomNode = new RandomListNode(head.next.random.label);
                    nodeMap.put(head.next.random.label, randomNode);
                }
                newNode.next.random = randomNode;
            }
            head=head.next;
            newNode=newNode.next;
        }

        return newHead;
    }

    public static void main(String [] args){
        RandomListNode randomNode = new RandomListNode(1);
        RandomListNode randomNode2 = new RandomListNode(2);
        randomNode.next=randomNode2;
        randomNode.random=randomNode2;
        randomNode2.random=randomNode2;

        RandomListNode output = new CopyListwithRandomPointer().copyRandomList(randomNode);

        RandomListNode temp = output;
        while(temp!=null){
            System.out.println("temp.label: "+temp.label);

            if(temp.next!=null){
                System.out.println("temp.next: "+temp.next.label);
            }
            if(temp.random!=null){
                System.out.println("temp.random: "+temp.random.label);
            }
            temp=temp.next;
        }
    }
}
  // Definition for singly-linked list with a random pointer.
  class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
  }