package edu.northeastern.ashish;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree <T>{

    /// region Class 1

    public Node<T> root;

    public BinaryTree(){
        this.root = null;
    }

    public void mirrorTree(){
        mirrorTree(root);
    }
    private void mirrorTree(Node<T> node){
        if(node == null){
            return;
        }
        mirrorTree(node.left);
        mirrorTree(node.right);
        Node<T> temp = node.left;
        node.left = node.right;
        node.right = temp;

    }

    public boolean isSameTree(Node<T> node1, Node<T> node2){
        if(node1 == null && node2 == null){
            return true;
        }

        if(node1 == null || node2 == null){
            return false;
        }
        return  node1.data == node2.data &&
                isSameTree(node1.left, node2.left) &&
                isSameTree(node1.right, node2.right);
    }




    public boolean areIsomorphic(Node<T> node1, Node<T> node2){
        if(node1 == null && node2 == null){
            return true;
        }

        if(node1 == null || node2 == null){
            return false;
        }
        return areIsomorphic(node1.left, node2.left) && areIsomorphic(node1.right, node2.right);
    }

    public boolean isFoldable(){
        return isFoldable(root);
    }

    public boolean isFoldable(Node<T> node){
        if(node == null){
            return true;
        }
        mirrorTree(node.right);
        boolean isomorphic = areIsomorphic(node.left, node.right);
        mirrorTree(node.right);

        return isomorphic;

    }



    /// Level Order
    public void levelOrder(){
        if(root == null){
            return;
        }
        Queue< Node<T> > queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while( queue.isEmpty() == false ){
            Node<T> node = queue.remove();
            if(node != null){
                System.out.print(node.data + ", ");
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }else{
                System.out.println();

                // Node was null
                // Check if the queue is empty if it is then break out of the loop
                // otherwise we will go in infinite loop
                if(queue.isEmpty()){
                    break;
                }
                queue.add(null);
            }
        }
        System.out.println();
    }

    public  boolean symmetricTree(){
        if( root == null || (root.left == null && root.right == null) ){
            return true;
        }
        Node<T> node1 = root.left;
        Node<T> node2 = root.right;
        mirrorTree(node2);

        return isSameTree(node1, node2);

    }

}
