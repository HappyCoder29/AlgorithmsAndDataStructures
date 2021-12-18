package edu.northeastern.ashish;

public class Main {
//106. Construct Binary Tree from Inorder and Postorder Traversal
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        Integer[] inOrder = {9,3,15,20,7};
        Integer[] postOrder = {9,15,7,20,3};
        Node<Integer> node = tree.constructTreeFromInOrderAndPostOrder(inOrder, postOrder);
        tree.root = node;
        tree.levelOrder();
    }
}
