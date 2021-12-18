package edu.northeastern.ashish;
//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class Main {

    public static void main(String[] args) {
	    BinaryTree<Integer> tree = new BinaryTree<>();
        Integer[] preOrder =  {-1};
        Integer[] inOrder = {-1};
        Node<Integer> node =  tree.constructTreeFromInOrderAndPreOrder(inOrder, preOrder);
        tree.root = node;
        tree.levelOrder();
    }
}
