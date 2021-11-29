package edu.northeastern.ashish;
//https://leetcode.com/problems/binary-tree-maximum-path-sum/
public class Main {

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.root = createTree();
        System.out.println(tree.sumMaxPath());
    }

    private static Node<Integer> createTree(){
        Node<Integer> root = new Node(-10);

        // Second level
        root.left = new Node<>(9);
        root.right = new Node<>(20);

        // Third Level
        root.right.left = new Node<>(15);
        root.right.right = new Node<>(7);

        root.right.left.left = new Node<>(3);
        root.right.left.right = new Node<>(2);

        root.right.right.left = new Node<>(5);
        root.right.right.right = new Node<>(7);
        return root;
    }
}
