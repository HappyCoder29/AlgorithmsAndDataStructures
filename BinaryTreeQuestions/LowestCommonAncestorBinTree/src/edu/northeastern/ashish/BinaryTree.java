package edu.northeastern.ashish;

public class BinaryTree <T> {
    public Node<T> root;

    public BinaryTree() {
    }

    public Node<T> lowestCommonAncestor(Node<T> node1, Node<T> node2){
        if(node1 == null || node2 == null || root == null){
            return null;
        }
        if(node1 == node2){
            return node1;
        }
        return lowestCommonAncestor(root, node1, node2);
    }

    private Node<T> lowestCommonAncestor(Node<T> node, Node<T> node1, Node<T> node2){
        if(node == null){
            return null;
        }
        if(node == node1 || node == node2){
            return node;
        }
        Node<T> left = lowestCommonAncestor(node.left, node1, node2);
        Node<T> right = lowestCommonAncestor(node.right, node1, node2);

        if(left != null && right != null) {
            return node;
        }
        if(left != null){
            return  left;
        }
        return right;



    }
}
