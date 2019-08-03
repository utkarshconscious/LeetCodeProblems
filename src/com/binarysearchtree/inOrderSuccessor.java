package com.binarysearchtree;

//Case: 1
//If the node has a right subtree, then find the least value node from the right subtree.

//Case: 2
//If the node does not have a right subtree, search that 'P' from root,
//the node from where we take the last left is the answer

public class inOrderSuccessor {

    public static int inOrderSuccessor(TreeNode root,TreeNode node){

//Case: 1
//If the node has a right subtree, then find the least value node from the right subtree.
        if(node.right!=null){
            node=node.right;
            while (node.left!=null){
                node=node.left;
            }
            System.out.println(node.val);
            return node.val;
        }

        TreeNode tempNode =root;
        TreeNode output =root;

//Case: 2
//If the node does not have a right subtree, search that 'P' from root,
//the node from where we take the last left is the answer
        while (true) {
            if (tempNode.val > node.val) {
                output = tempNode;
                tempNode=tempNode.left;
            }
            else if(tempNode.val>node.val)
                tempNode=tempNode.right;

            else {
                System.out.println(output.val);
                return output.val;
            }

        }
    }
}
