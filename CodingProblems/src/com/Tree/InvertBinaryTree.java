package com.Tree;

import java.util.LinkedList;

public class InvertBinaryTree {

    public void invertBinaryTree(BinaryTree tree) {
        // Write your code here.
        preNodeSwap(tree);
    }

     void preNodeSwap(BinaryTree tree) {
        if(tree == null) {
            return;
        }
        BinaryTree left = tree.left;
        tree.left= tree.right;
        tree.right = left;

        preNodeSwap(tree.left);
        preNodeSwap(tree.right);
    }


    void BFSIterative(BinaryTree tree){

        LinkedList<BinaryTree> queue = new LinkedList<>();

        queue.add(tree);
        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int s = 0; s < size; s++) {
                BinaryTree t = queue.remove();
                BinaryTree left = t.left;
                t.left= t.right;
                t.right = left;
                if(t.left != null) queue.add(t.left);
                if(t.right != null) queue.add(t.right);
            }
        }
    }
}
