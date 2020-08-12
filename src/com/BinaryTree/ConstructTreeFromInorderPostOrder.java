package com.BinaryTree;

public class ConstructTreeFromInorderPostOrder {

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if(inorder.length==0 ||postorder.length==0)
            return null;
        Index pIndex = new Index();
        pIndex.index = postorder.length-1;
        return build(inorder,postorder,pIndex,0,postorder.length-1);
    }

    public TreeNode build(int[] inorder, int[] postorder, Index pIndex, int start, int end){

        if(start>end)
            return null;

        if(start==end) {
            TreeNode node = new TreeNode(postorder[pIndex.index]);
            pIndex.index--;
            return node;
        }
        TreeNode node = new TreeNode(postorder[pIndex.index]);
        int index=search(inorder,start,end,postorder[pIndex.index]);
        pIndex.index--;
        node.right=build(inorder,postorder,pIndex,index+1,end);
        node.left=build(inorder,postorder,pIndex,start,index-1);


        return node;
    }

    int search(int arr[], int strt, int end, int value)
    {
        int i;
        for (i = strt; i <= end; i++) {
            if (arr[i] == value)
                break;
        }
        return i;
    }

   private class Index {
        int index;
    }

    void preOrder(TreeNode node)
    {
        if (node == null)
            return;
        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);
    }


    public static void main(String[] args)
    {
        ConstructTreeFromInorderPostOrder tree = new ConstructTreeFromInorderPostOrder();
        int in[] = new int[] { 4,2,5,1,6,3,7};
        int post[] = new int[] { 4,5,2,6,7,3,1};
        int n = in.length;
        TreeNode root = tree.buildTree(in, post);
        System.out.println("Preorder of the constructed tree : ");
        tree.preOrder(root);
    }

}
