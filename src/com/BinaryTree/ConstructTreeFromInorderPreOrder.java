package com.BinaryTree;

public class ConstructTreeFromInorderPreOrder {

    public TreeNode buildTree(int[] preorder ,int[] inorder) {

        if(inorder.length==0 ||preorder.length==0)
            return null;
        Index pIndex = new Index();
        pIndex.index = 0;
        return build(inorder,preorder,pIndex,0,preorder.length-1);
    }

    public TreeNode build(int[] inorder, int[] preorder, Index pIndex, int start, int end){

        if(start>end)
            return null;

        if(start==end) {
            TreeNode node = new TreeNode(preorder[pIndex.index]);
            pIndex.index++;
            return node;
        }
        TreeNode node = new TreeNode(preorder[pIndex.index]);
        int index=search(inorder,start,end,preorder[pIndex.index]);
        pIndex.index++;

        node.left=build(inorder,preorder,pIndex,start,index-1);
        node.right=build(inorder,preorder,pIndex,index+1,end);


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
        ConstructTreeFromInorderPreOrder tree = new ConstructTreeFromInorderPreOrder();
        //int in[] = new int[] { 4,2,5,1,6,3,7};
        int in[] = new int[] { 9,3,15,20,7};
        //int pre[] = new int[] { 1,2,4,5,3,6,7};
        int pre[] = new int[] { 3,9,20,15,7};
        int n = in.length;
        TreeNode root = tree.buildTree(in, pre);
        System.out.println("Preorder of the constructed tree : ");
        tree.preOrder(root);
    }
}
