package edu.northeastern.ashish;

public class Main {
//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
    public static void main(String[] args) {
        BST tree = new BST();
        int[] arr = {-10,-3,0,5,9};
        tree.root =  tree.createBalancedBST(arr);
        tree.levelOrder();
    }


}
