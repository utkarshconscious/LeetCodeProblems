package com.binarysearchtree;

// Given the root of a binary tree, determine if it is a valid binary search tree (BST).
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        if (root != null) {
            return valid(root.left, null, root.val) &&
                    valid(root.right, root.val, null);
        }
        return true;
    }

    public boolean valid(TreeNode node, Integer min, Integer max) {
        if (node != null) {
            if ((max != null && node.val >= max) || (min != null && node.val <= min)) {
                return false;
            }
            return valid(node.left, min, node.val) &&
                    valid(node.right, node.val, max);
        }
        return true;
    }

    public static void main(String [] args){
        System.out.println(Integer.MIN_VALUE );
        System.out.println(Integer.MAX_VALUE);
    }

}



