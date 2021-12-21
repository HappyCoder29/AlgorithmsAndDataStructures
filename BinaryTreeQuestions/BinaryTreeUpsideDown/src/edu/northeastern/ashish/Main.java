package edu.northeastern.ashish;

public class Main {

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.root = createTree();
        tree.turnUpsideDown();
        System.out.println();
    }

    private static Node<Integer> createTree(){
        Node<Integer> root = new Node<>(1);
        root.left = new Node<>(2);
        root.right = new Node<>(3);
        root.left.left = new Node<>(4);
        root.left.right = new Node<>(5);
        return root;

    }
}
