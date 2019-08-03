package com.binarysearchtree;

import com.BinaryTree.*;

public class FindInOrderPredecessor {

//    Case 1:
//    If the node 'P' has a left subtree, then jump to that
//    left child and go to the right most node (max value in the left subtree)

//     Case 2:
//     If the node 'P' does not have a left subtree,
//     Search that node from the root and the node from where
//     we take the last right is the answer.
    public static int inOrderPredecessor(TreeNode root,TreeNode node){

//    Case 1:
//    If the node 'P' has a left subtree, then jump to that
//    left child and go to the right most node (max value in the left subtree)
        if(node.left!=null){
            TreeNode temp = node.left;
            while(temp.right!=null)
                temp=temp.right;
            System.out.println(temp.val);
            return temp.val;
        }

//        Case 2:
//        If the node 'P' does not have a left subtree,
//        Search that node from the root and the node from where
//        we take the last right is the answer
        TreeNode predecessor=null;
        TreeNode tempNode=root;

        while (true) {
            if (tempNode.val > node.val)
                tempNode = tempNode.left;
            else if (tempNode.val < node.val) {
                tempNode = tempNode.right;
                predecessor = tempNode;
            } else if (tempNode.val == node.val) {
                if (predecessor != null) {
                    System.out.println(predecessor.val);
                    return predecessor.val;
                }
            }
            return 0;
        }

    }

}
