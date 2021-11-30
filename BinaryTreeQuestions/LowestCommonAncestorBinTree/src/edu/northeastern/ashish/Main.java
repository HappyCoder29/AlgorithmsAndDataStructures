package edu.northeastern.ashish;
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
public class Main {

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.root = createTree();
        Node<Integer> node1 = tree.root.left;
        Node<Integer> node2 = tree.root.right.right;

        Node<Integer> ancestor = tree.lowestCommonAncestor(node1, node2);


        System.out.println();
    }

    private static Node<Integer> createTree(){
        Node<Integer> root = new Node(3);

        // Second level
        root.left = new Node<>(5);
        root.right = new Node<>(1);

        root.left.left = new Node<>(6);
        root.left.right = new Node<>(2);

        root.right.left = new Node<>(0);
        root.right.right = new Node<>(8);

        root.left.right.left = new Node<>(7);
        root.left.right.right = new Node<>(4);




        return root;
    }
}
