package edu.northeastern.ashish;

public class Main {

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.root = createTree();
        tree.boundary();

    }

    public static Node<Integer> createTree(){
        Node<Integer> root = new Node<>(1);

        // First Level
        root.left = new Node<>(2);
        root.right = new Node<>(3);

        // Second level
        root.left.left = new Node<>(4);
        root.left.right = new Node<>(5);
        root.right.left = new Node<>(6);
        root.right.right = new Node<>(7);

        // Third Level
        root.left.left.left = new Node<>(8);
        root.left.right.left = new Node<>(9);
        root.right.left.right = new Node<>(10);
        root.right.right.right = new Node<>(11);

        return root;
    }
}
