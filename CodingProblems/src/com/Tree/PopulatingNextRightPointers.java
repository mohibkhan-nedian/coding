package com.Tree;

import java.util.LinkedList;

public class PopulatingNextRightPointers {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        LinkedList<Node> queue = new LinkedList<>();

        queue.add(root);
        while (queue.size() > 0) {
            Node prevNode = null;
            int size = queue.size();

            //Iterate over all nodes in current level
            for(int i = 0; i < size; i++) {
                Node node = queue.remove();
                if(prevNode != null){
                    prevNode.next = node;

                }
                prevNode = node;

                // add children
                // though we are adding but this will not be read in current iteration because the for loop is already set to run for only no. nodes from prev level
                if (node.left !=  null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }
}
