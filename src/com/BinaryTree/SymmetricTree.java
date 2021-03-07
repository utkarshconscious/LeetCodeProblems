package com.BinaryTree;

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return checkSymetry(root.left, root.right);
    }

    private boolean checkSymetry(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null)
            return true;
        else if ((n1 == null && n2 != null) || (n1 != null && n2 == null))
            return false;
        if (n1.val != n2.val)
            return false;
        return (checkSymetry(n1.left, n2.right) && checkSymetry(n1.right, n2.left));

    }
}
