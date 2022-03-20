package com.Tree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> levels = new ArrayList<List<Integer>>();

        if (root == null) {
            return levels;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new LinkedList<>();

            for(int i = 0; i < size; i++) {
                TreeNode current = queue.remove();
                list.add(current.val);

                if(current.left!=null) queue.add(current.left);
                if(current.right!=null) queue.add(current.right);
            }
            levels.add(list);
        }
        return levels;
    }

}
