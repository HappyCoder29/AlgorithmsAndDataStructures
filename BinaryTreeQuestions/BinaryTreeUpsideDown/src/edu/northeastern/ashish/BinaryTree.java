package edu.northeastern.ashish;

public class BinaryTree <T> {
    public Node<T> root;

    public BinaryTree() {
    }

    public void turnUpsideDown(){
        if(root == null){
            return;
        }
        root = turnUpsideDown(root, null, null);
    }


    private Node<T> turnUpsideDown(Node<T> node, Node<T> parent, Node<T> right){

        if(node == null){
            return parent;
        }

        Node<T> newNode =  turnUpsideDown(node.left, node, node.right );
        node.left = right;
        node.right = parent;

        return newNode;
    }

}
