package edu.northeastern.ashish;

public class Main {
//https://leetcode.com/problems/convert-bst-to-greater-tree/
    public static void main(String[] args) {
        BST tree = new BST();
        tree.root = createTree();
        tree.convertToGreaterSum();
        tree.inOrder();
        tree.levelOrder();
    }

    public static Node createTree(){
        Node root = new Node(4);
        root.left= new Node(1);
        root.right= new Node(6);

        root.left.left= new Node(0);
        root.left.right= new Node(2);
        root.right.left= new Node(5);
        root.right.right= new Node(7);

        root.left.right.right= new Node(3);
        root.right.right.right= new Node(8);



        return  root;
    }
}
