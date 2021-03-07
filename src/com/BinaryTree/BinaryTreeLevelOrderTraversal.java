package com.BinaryTree;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> output = new ArrayList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int i = queue.size();
            List<Integer> list = new ArrayList<>();
            while (i > 0) {
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
                i--;
            }
            output.add(list);
        }
        return output;
    }
}
