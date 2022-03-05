package com.Tree;

public class BinaryTreeDiameter {

    public int preOrder(BinaryTree tree) {

        if (tree == null) return 0;
        //calc diam for this node
        //diam = height of left tree + height or right tree
        int h1 = height(tree.left);
        int h2 = height(tree.right);
        int dia = h1 + h2;

        //calc diam of left and right trees
        int dia1 = preOrder(tree.left);
        int dia2 = preOrder(tree.right);

        //return highest diam from current tree, left tree and right tree
        if (dia > dia1 && dia > dia2) return dia;
        else if (dia1 > dia && dia1 > dia2) return dia1;
        else return dia2;
    }

    int height(BinaryTree t){
        if(t == null) return 0;
        int h1 = height(t.left) + 1;
        int h2 = height(t.right) + 1;
        return Math.max(h1, h2);
    }
    /////////////////////////////////////////////////////////////

    //Preorder is costly because you are calculating height 2 times for each node, once for itself and once for its parent
    //one way to optimize is using hashmap to store the height once calculated
    //other way is to use PostOrder, and from each node return height and dia at same time in a new object
    //O(N) Time, O(D) space

    public int binaryTreeDiameter(BinaryTree tree) {
        // Write your code here.
        TreeInfo t = postOrder(tree);
        return t.diameter;
    }

    TreeInfo postOrder(BinaryTree tree) {
        if(tree==null) return new TreeInfo(0, 0);

        TreeInfo left = postOrder(tree.left);
        TreeInfo right = postOrder(tree.right);

        int dia = left.height + right.height;
        int maxDia = Math.max(dia, left.diameter);
        maxDia = Math.max(maxDia, right.diameter);
        return new TreeInfo(maxDia, Math.max(left.height, right.height) + 1);
    }

    public class TreeInfo {
        int diameter;
        int height;
        public TreeInfo(int d, int h){
            this.diameter = d;
            this.height = h;
        }
    }
}
