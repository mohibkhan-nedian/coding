package com.BST;

import java.util.ArrayList;

public class ReconstructBST { static class BST {
    public int value;
    public BST left = null;
    public BST right = null;

    public BST(int value) {
        this.value = value;
    }
}

    //Note how global var is used for keep track of next index in array to insert in tree
    //2. See how instead of returning the nextindex var as return type of each recursive call got simplified by use of global var.
    int nextIndex = 0;

    public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
        // Write your code here.
        return reconstructBst(Integer.MIN_VALUE, Integer.MAX_VALUE, preOrderTraversalValues);
    }

    public BST reconstructBst(int min, int max, ArrayList<Integer> preOrderTraversalValues) {
        if(preOrderTraversalValues.size() == nextIndex)
            return null;

        int rootValue = preOrderTraversalValues.get(nextIndex);
        if(rootValue >= max || rootValue < min) {
            return null;
        }

        BST bst = new BST(rootValue);
        nextIndex += 1;
        bst.left = reconstructBst(min, rootValue, preOrderTraversalValues);
        bst.right = reconstructBst(rootValue, max, preOrderTraversalValues);

        return bst;
    }
}
