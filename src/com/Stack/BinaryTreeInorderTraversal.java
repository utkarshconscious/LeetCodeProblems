package com.Stack;


import java.util.*;

public class BinaryTreeInorderTraversal {

List<Integer> traversal = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {

        inorder(root);
        return traversal;


    }

    public void inorder(TreeNode root){

        if(root==null)
            return;
        inorder(root.left);
        traversal.add(root.val);

        inorder(root.right);
    }

    public List<Integer> inorderTraversalStack(TreeNode root) {

        if(root==null)
            return traversal;
        Stack<TreeNode> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        TreeNode temp = null;
        stack.push(root);

        while(!stack.isEmpty()){
            if(stack.peek().left!=null) {
                temp=stack.peek().left;
                stack.peek().left=null;
                stack.push(temp);
                continue;
            }

            temp=stack.pop();
            traversal.add(temp.val);
            if(temp.right!=null) {
                stack.push(temp.right);
            }

        }
        return traversal;
    }




  public static void main(String [] args){
      TreeNode node1 = new TreeNode(1);
      TreeNode node2 = new TreeNode(2);
      TreeNode node3 = new TreeNode(3);
      TreeNode node4 = new TreeNode(2);
      node1.left=node2;
      node1.right=node3;
      node3.left=node4;

      List<Integer> output = new BinaryTreeInorderTraversal().inorderTraversalStack(node1);
      for(Integer out: output){
          System.out.println(out);
      }
  }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}