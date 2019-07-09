package com.Stack;

import java.util.*;

public class CloneGraph {

Map<Integer,UndirectedGraphNode> map = new HashMap<>();

// DFS
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

        if(node==null)
            return null;
        UndirectedGraphNode newNode = map.get(node.label);
        if (newNode==null) {
            newNode = new UndirectedGraphNode(node.label);
            map.put(node.label, newNode);
        }
        else{
            return newNode;
        }
        for(UndirectedGraphNode childNode: node.neighbors){

            newNode.neighbors.add(cloneGraph(childNode));
        }

        return newNode;

    }

    public UndirectedGraphNode cloneGraphBFS(UndirectedGraphNode node) {

        if(node==null)
            return null;
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
            map.put(node.label, newNode);
        queue.offer(node);

        while(!queue.isEmpty()){
            UndirectedGraphNode curNode = queue.poll();
            UndirectedGraphNode cloneNode = map.get(curNode.label);
            for(UndirectedGraphNode childNode:curNode.neighbors){
                if(map.containsKey(childNode.label)) {
                    cloneNode.neighbors.add(map.get(childNode.label));
                    continue;
                }
                UndirectedGraphNode newChild = new UndirectedGraphNode(childNode.label);
                map.put(newChild.label,newChild);
                cloneNode.neighbors.add(newChild);
                queue.offer(childNode);
            }



        }
        return newNode;

    }
    public static void main(String [] args){

        UndirectedGraphNode node1= new UndirectedGraphNode(1);
        UndirectedGraphNode node2= new UndirectedGraphNode(2);
        UndirectedGraphNode node3= new UndirectedGraphNode(3);
        node1.neighbors.add(node1);
        node1.neighbors.add(node1);

        UndirectedGraphNode output = new CloneGraph().cloneGraphBFS(node1);
        System.out.println(output.label);
        for(UndirectedGraphNode node: output.neighbors){
            System.out.println("child: "+node.label);
        }
    }


}

class UndirectedGraphNode {

    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}