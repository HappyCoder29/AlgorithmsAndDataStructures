package edu.northeastern.ashish;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.root = createTree();

        Node<Integer> commonAncestor = tree.lowestCommonAncestor(tree.root.left, tree.root.left.right.left);

        System.out.println(commonAncestor.data);



    }

    private static Node<Integer> createTree(){
        Node<Integer> root = new Node<>(1);
        root.parent = null;

        // Second level
        root.left = new Node<>(2);
        root.left.parent = root;
        root.right = new Node<>(3);
        root.right.parent = root;
        // Third Level
        root.left.left = new Node<>(4);
        root.left.right = new Node<>(5);
        root.left.left.parent = root.left;
        root.left.right.parent = root.left;

        root.right.left = new Node<>(6);
        root.right.right = new Node<>(7);
        root.right.left.parent = root.right;
        root.right.right.parent = root.right;

        // Fourth Level
        root.left.left.left = new Node<>(8);
        root.left.left.left.parent = root.left.left;

        root.left.right.left = new Node<>(9);
        root.left.right.left.parent =  root.left.right;

        root.right.left.left = new Node<>(10);
        root.right.left.left.parent = root.right.left;
        root.right.right.right = new Node<>(11);
        root.right.right.right.parent = root.right.right;

        return root;
    }

    private static Node<Integer> createBST(){
        Node<Integer> root = new Node<>(8);

        // Second level
        root.left = new Node<>(3);
        root.right = new Node<>(10);
        // Third Level
        root.left.left = new Node<>(1);
        root.left.right = new Node<>(6);
        root.right.right = new Node<>(14);


        // Fourth Level
        root.left.right.left = new Node<>(4);
        root.left.right.right = new Node<>(7);
        root.right.right.left = new Node<>(13);

        return root;
    }
}
