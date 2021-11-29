package edu.northeastern.ashish;
//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class Main {

    public static void main(String[] args) {
	    BinaryTree<Integer> tree = new BinaryTree<>();
        Integer[] preOrder =  {3,9,20,15,7};
        Integer[] inOrder = {9,3,15,20,7};
        Node<Integer> node =  tree.constructTreeFromInOrderAndPreOrder(inOrder, preOrder);
        tree.root = node;
        tree.levelOrder();
    }
}
