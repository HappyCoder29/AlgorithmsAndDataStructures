package edu.northeastern.ashish;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.root = createTree();
        ArrayList<ArrayList<Integer>> allList = tree.allPathSum(22);
        System.out.println();

    }

    public static Node<Integer> createTree(){
        Node<Integer> root = new Node<>(5);

        // First Level
        root.left = new Node<>(4);
        root.right = new Node<>(8);

        // Second level
        root.left.left = new Node<>(11);
        root.right.left = new Node<>(13);
        root.right.right = new Node<>(4);

        // Third Level
        root.left.left.left = new Node<>(7);
        root.left.left.right = new Node<>(2);
        root.right.right.left = new Node<>(5);
        root.right.right.right = new Node<>(1);


        return root;
    }
}
