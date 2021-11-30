package edu.northeastern.ashish;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.root = createTree();
        ArrayList<String> listPaths = tree.getAllPaths();
        int sum = 0;
        for (String str : listPaths) {
           sum += Integer.parseInt(str);
        }
        System.out.println(sum );

    }

    public static Node<Integer> createTree(){
        Node<Integer> root = new Node<>(4);

        // First Level
        root.left = new Node<>(9);
        root.right = new Node<>(0);

        root.left.left = new Node<>(5);
        root.left.right = new Node<>(1);

//        // Second level
//        root.left.left = new Node<>(11);
//        root.right.left = new Node<>(13);
//        root.right.right = new Node<>(4);
//
//        // Third Level
//        root.left.left.left = new Node<>(7);
//        root.left.left.right = new Node<>(2);
//        root.right.right.left = new Node<>(5);
//        root.right.right.right = new Node<>(1);


        return root;
    }
}
