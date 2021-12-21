package edu.northeastern.ashish;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree <T> {
    public Node<T> root;
    public BinaryTree() {this.root = null;}

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

    // O(n) space O( log(n))
    public void populateNextRight(){
        if(root == null){
            return;
        }
        Queue< Node<T> > queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        Node<T> prevNode = null;

        while( queue.isEmpty() == false ){
            Node<T> node = queue.remove();
            if(node != null){
                if(prevNode != null){
                    prevNode.nextRight = node;
                }
                prevNode = node;
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
                prevNode = null;
            }
        }
        System.out.println();
    }


    // O(n) space O( log(n))
    public void populateNextLeft(){
        if(root == null){
            return;
        }
        Queue< Node<T> > queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        Node<T> prevNode = null;

        while( queue.isEmpty() == false ){
            Node<T> node = queue.remove();
            if(node != null){
                if(prevNode != null){
                    node.nextLeft = prevNode;
                }
                prevNode = node;
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
                prevNode = null;
            }
        }
        System.out.println();
    }

}

