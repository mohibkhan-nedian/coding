package com.Tree;

public class BinaryTree {

     int val;
      BinaryTree left;
      BinaryTree right;
      BinaryTree() {}
      BinaryTree(int val) { this.val = val; }
      BinaryTree(int val, BinaryTree left, BinaryTree right) {
          this.val = val;
          this.left = left;
          this.right = right;
     }

}
