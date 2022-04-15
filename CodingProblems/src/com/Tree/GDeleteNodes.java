package com.Tree;

public class GDeleteNodes {
    List<TreeNode> result = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        if(root==null || to_delete.length == 0) return result;

        HashSet<Integer> hashset = new HashSet<>();
        for(int i : to_delete){
            hashset.add(i);
        }
        TreeNode r = postDFS(root, hashset);
        if (!hashset.contains(root.val)) {
            result.add(r);
        }
        return result;
    }

    TreeNode postDFS(TreeNode root, HashSet<Integer> to_delete) {
        if(root == null){
            return null;
        }

        root.left = postDFS(root.left, to_delete);
        root.right = postDFS(root.right, to_delete);

        if(to_delete.contains(root.val)){
            if(root.left!=null) result.add(root.left);
            if(root.right!=null)  result.add(root.right);
            return null;
        }
        return root;
    }


}
