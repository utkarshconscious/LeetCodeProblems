package com.BinaryTree;

import java.util.*;

public class BinaryTreeInOrderTraversal {

    public static List<Integer> inorderTraversal(TreeNode root) {

        if (root == null)
            return new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (true) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (stack.isEmpty())
                break;

            output.add(stack.peek().val);
            node = stack.pop().right;
        }
        return output;
    }

    public static void main (String [] args){
        TreeNode root ;
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(inorderTraversal(root));

    }

}
