package com.BinaryTree;


import java.util.*;


public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {

        if (root == null)
            return new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            output.add(temp.val);
            if(temp.right!=null)
                stack.push(temp.right);
            if(temp.left!=null)
                stack.push(temp.left);

        }
            return output;
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}