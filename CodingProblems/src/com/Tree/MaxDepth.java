package com.Tree;

public class MaxDepth {

    private int answer; // don't forget to initialize answer before call maximum_depth

    //Top - down approach - note no return type and we set answer in global var
    private void maximum_depth(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        //if leaf node set answer
        if (root.left == null && root.right == null) {
            answer = Math.max(answer, depth);
        }
        maximum_depth(root.left, depth + 1);
        maximum_depth(root.right, depth + 1);
    }

    //Bottom up approach - note that we have return type here
    public int maximum_depth(TreeNode root) {
        if (root == null) {
            return 0;          // return 0 for null node
        }
        int left_depth = maximum_depth(root.left);
        int right_depth = maximum_depth(root.right);
        return 1 + Math.max(left_depth, right_depth);   // return depth of the subtree rooted at root
    }
}
