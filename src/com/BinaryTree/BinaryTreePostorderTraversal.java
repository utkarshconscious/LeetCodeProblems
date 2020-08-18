package com.BinaryTree;

import java.util.*;

public class BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {

        if (root == null)
            return new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.peek();

            if (temp.left == null && temp.right == null) {
                output.add(temp.val);
                stack.pop();
            }

            if (temp.right != null) {
                stack.push(temp.right);
                temp.right = null;
            }
            if (temp.left != null) {
                stack.push(temp.left);
                temp.left = null;
            }

        }
        return output;
    }


}


