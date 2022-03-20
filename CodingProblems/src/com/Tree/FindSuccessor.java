package com.Tree;

public class FindSuccessor {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    //O(h) or O(n) time for unbalance or O(logn) for balanced because we may have to go deep into one branch
    //O(1) space
    public BinaryTree findSuccessor(BinaryTree node) {

        // Inorder is LNR .
        // When you are on that node N from LNR, next will be its Right. In that right tree again LNR so the left most
        // if a node is right  then next will be the parent of which it was a left child

        if(node.right!= null) return findLeftMostNode(node.right);
        return getRightMostParent(node);

    }

    public BinaryTree findLeftMostNode(BinaryTree node){
        //node will have right child, if no left child then that right child will be next passed to this fn
        BinaryTree currentNode = node;
        while(currentNode.left!=null){
            currentNode = currentNode.left;
        }
        return currentNode;
    }

    public BinaryTree getRightMostParent(BinaryTree node){
        //if node is left child we wont go into loop and return parent of node which will be next
        // else go to parent of node until node is right child of parent, loop will stop when node is left child of parent, then that parent will be next
        BinaryTree currentNode = node;
        while(currentNode.parent!= null && currentNode.parent.right == currentNode) {
            currentNode = currentNode.parent;
        }
        return currentNode.parent;
    }
}
