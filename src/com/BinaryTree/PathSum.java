package com.BinaryTree;

public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root==null)
            return false;
        return pathSum(root,root.val,sum);
    }

    private boolean pathSum(TreeNode node,int currSum, int sum){

        if(node.left==null && node.right==null){
            if(currSum==sum)
                return true;
            else return false;
        }
        else if(node.right==null)
            return pathSum(node.left,currSum+node.left.val,sum);

        else if(node.left==null)
            return pathSum(node.right,currSum+node.right.val,sum);

        return (pathSum(node.left,currSum+node.left.val,sum)||pathSum(node.right,currSum+node.right.val,sum));
    }
}
