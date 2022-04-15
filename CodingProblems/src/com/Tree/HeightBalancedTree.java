package com.Tree;

public class HeightBalancedTree {

    //O(n) time every node is visited
    //O(h) space - height between log n to n

    static class TreeInfo{
        int height ;
        boolean isBalanced;
        public TreeInfo(boolean f , int h){
            this.isBalanced = f;
            this.height = h;
        }
    }

    TreeInfo getTreeInfo(BinaryTree tree){
        if(tree == null) return new TreeInfo(true, -1);

        TreeInfo left = getTreeInfo(tree.left);
        TreeInfo right = getTreeInfo(tree.right);

        int h = 1 + Math.max(left.height,  right.height);
        boolean isBalanced = Math.abs(left.height - right.height ) <= 1 && left.isBalanced && right.isBalanced;

        return new TreeInfo(isBalanced, h);
    }
}
