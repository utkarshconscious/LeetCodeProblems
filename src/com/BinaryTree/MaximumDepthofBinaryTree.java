package com.BinaryTree;

public class MaximumDepthofBinaryTree {

    public int maxDepth(TreeNode root) {
       if(root==null)
            return 0;
      return findDepth(root);

    }

    public int findDepth(TreeNode node){
        if(node==null)
            return 0;
        int left = findDepth(node.left);
        int right= findDepth(node.right);
        return Math.max(left,right)+1;
    }

}
