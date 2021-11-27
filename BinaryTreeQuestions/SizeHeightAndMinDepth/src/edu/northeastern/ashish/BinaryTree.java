package edu.northeastern.ashish;

public class BinaryTree <T> {
    public Node<T> root;

    public BinaryTree() {

    }

    public int size(){
        return size(root);
    }
    private int size(Node<T> node){
        if(node == null){
            return 0;
        }
        return 1 + size(node.left) + size(node.right);
    }

    public int height(){
        return height(root);
    }

    private int height(Node<T> node){
        if(node == null){
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return 1 + Math.max(leftHeight, rightHeight);

    }

    public int minheight(){
        return minheight(root);
    }

    private int minheight(Node<T> node){
        if(node == null){
            return 0;
        }

        int leftHeight = minheight(node.left);
        int rightHeight = minheight(node.right);

        return 1 + Math.min(leftHeight, rightHeight);

    }
}
