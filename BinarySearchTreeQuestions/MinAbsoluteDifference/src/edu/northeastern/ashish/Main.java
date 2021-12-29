package edu.northeastern.ashish;

public class Main {
//https://leetcode.com/problems/minimum-absolute-difference-in-bst/
    public static void main(String[] args) {
        BST tree = new BST();
        tree.root = createBST();

        System.out.println(tree.minAbsoluteDifference());

    }

    private static  Node createBST(){
        Node root = new Node(4);

        root.left = new Node(2);
        root.right = new Node(6);

        root.left.left = new Node(1);
        root.left.right = new Node(3);

        return  root;
    }
}
