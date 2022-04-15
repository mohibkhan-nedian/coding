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

    // Function to construct an expression tree from the given postfix expression
    public static Node construct(String postfix)
    {
        // base case
        if (postfix == null || postfix.length() == 0) {
            return null;
        }

        // create an empty stack to store tree pointers
        Stack<Node> s = new Stack<>();

        // traverse the postfix expression
        for (char c: postfix.toCharArray())
        {
            // if the current token is an operator
            if (isOperator(c))
            {
                // pop two nodes `x` and `y` from the stack
                Node x = s.pop();
                Node y = s.pop();

                // construct a new binary tree whose root is the operator and whose
                // left and right children point to `y` and `x`, respectively
                Node node = new Node(c, y, x);

                // push the current node into the stack
                s.add(node);
            }
            // if the current token is an operand, create a new binary tree node
            // whose root is the operand and push it into the stack
            else {
                s.add(new Node(c));
            }
        }

        // a pointer to the root of the expression tree remains on the stack
        return s.peek();
    }

    //convert infix to postfix
/*
    1. if char is number , add to exp
    2. if char is ( , add to stack
    3. if char is ), pop from stack and add to exp until ( is found, then remove ( but dont add to exp
    4. else if char +-/*, then kep remove from stack if you find operator of higher priority on stack and add to exp because that will be evaluated first in postfix so 34* then + will come. then add current char to stack
 */

func infixToPostFix(_ expression: String) -> String {
    var stack = [Character]()
    var postfixExp = ""

    for char in expression {
        if char.isNumber || char.isLetter {
            postfixExp.append(char)
        } else if char == "(" {
            stack.append("(")
        } else if char == ")" {
            while !stack.isEmpty, let char = stack.last, char != "(" {
                postfixExp.append(stack.removeLast())
            }
            stack.removeLast()
        } else {
            while !stack.isEmpty,
                  let last = stack.last,
                  operatorPrecedence(char) <= operatorPrecedence(last) {
                postfixExp.append(last)
                stack.removeLast()
            }
            stack.append(char)
        }
    }

    while !stack.isEmpty {
        postfixExp.append(stack.removeLast())
    }

    return postfixExp
}


}
