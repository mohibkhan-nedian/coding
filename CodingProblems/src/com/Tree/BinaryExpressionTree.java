package com.Tree;

public class BinaryExpressionTree {

    static class BinaryTreeNode {

        char val;
        BinaryTreeNode left;
        BinaryTreeNode right;
        BinaryTreeNode() {}
        BinaryTreeNode(char val) { this.val = val; }
        BinaryTreeNode(char val, BinaryTreeNode left, BinaryTreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

        public static void inorder(BinaryTreeNode root)
    {
        if (root == null) {
            return;
        }

        //If the current node is an operator,
        if(isOperator(root.val)){
            System.out.println("(");
        }
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);

        //whenever you are operand node, after you have printed its right subtree you always have to close the parenthesis
        //so check if this was a operand after printing right subtree and then print closing parenthese
        if(isOperator(root.val)){
            System.out.println(")");
        }
    }

    private static boolean isOperator(char val) {
        if(val=='+' || val =='-'||val=='*' || val == '/'){
            return true;
        }
        return false;
    }
}
