package edu.northeastern.ashish;

public class Main {

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.root = createTree();
        tree.levelOrder();
        tree.mirrorTree();
        tree.levelOrder();

        tree.root = createTreeFoldable();
        System.out.println(tree.isFoldable());

    }

    public static Node<Integer> createTree(){
        Node<Integer> root = new Node<>(1);

        // First Level
        root.left = new Node<>(2);
        root.right = new Node<>(3);

        // Second level
        root.left.left = new Node<>(4);
        root.right.left = new Node<>(5);
        root.right.right = new Node<>(6);

        return root;
    }

    public static Node<Integer> createTreeFoldable(){
        Node<Integer> root = new Node<>(1);

        // First Level
        root.left = new Node<>(2);
        root.right = new Node<>(3);

        // Second level
        root.left.right = new Node<>(4);
        root.right.left = new Node<>(5);

        return root;
    }
}
