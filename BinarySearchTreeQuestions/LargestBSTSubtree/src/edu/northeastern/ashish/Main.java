package edu.northeastern.ashish;

public class Main {
//https://leetcode.com/problems/largest-bst-subtree/
    public static void main(String[] args) {
        BST tree = new BST();
        tree.root = createTree();
        Node largestBST = tree.findLargestBSTNode();
        System.out.println(tree.findLargestBST());
    }

    private static Node createTree(){
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);

        root.left.left = new Node(1);
        root.left.right = new Node(8);

        root.right.right = new Node(7);
        return root;

    }
}
