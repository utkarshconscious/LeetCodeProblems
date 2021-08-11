package com.topproblems;

public class AVLTree {

    private Node leftRotation(Node node) {
        Node newParent = node.left;
        node.left = newParent.right;
        newParent.right = node;
        newParent.height = Math.max(newParent.left.height, newParent.right.height) + 1;
        newParent.height = Math.max(newParent.left.height, newParent.right.height) + 1;
        return newParent;
    }

    private Node leftRightRotation(Node node) {
        node.left = rightRotation(node.left);
        return leftRotation(node);
    }

    private Node rightLeftRotation(Node node) {
        node.right = leftRotation(node.right);
        return rightRotation(node);
    }

    private Node rightRotation(Node node) {
        Node newParent = node.right;
        node.right = newParent.left;
        newParent.left = node;
        newParent.height = Math.max(newParent.left.height, newParent.right.height) + 1;
        node.height = Math.max(node.left.height, node.right.height) + 1;
        return newParent;
    }

    private class Node {
        int value;
        int height;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        public int height() {
            return height;
        }
    }
}
