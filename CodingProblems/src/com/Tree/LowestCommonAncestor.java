package com.Tree;

public class LowestCommonAncestor {
    
    ///Using Prenode traversal
    //O(n) time visit all nodes in worst case
    //O(h) space
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null)
            return null;
        if(root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p , q);

        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null) {
            // this node is LCA
            return root;
        }
        if(left == null && right == null) {
            // this node contain neither so return null
            return null;
        }

        return left != null ? left: right;
    }
    
}
