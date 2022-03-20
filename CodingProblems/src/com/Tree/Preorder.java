package com.Tree;

public class Preorder {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        preorderTraversal(root, list);
        return list;
    }

    public void preorderTraversal(TreeNode root, ArrayList<Integer> list) {
        if(root==null) return;
        list.add(root.val);
        preorderTraversal(root.left, list);
        preorderTraversal(root.right, list);
    }
}
