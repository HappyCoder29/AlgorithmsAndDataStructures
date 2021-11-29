package edu.northeastern.ashish;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree <T> {

    public Node<T> root;

    public BinaryTree() {

    }

    /// Level Order
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
               // System.out.print(node.data + ", ");
                if(prevNode != null){
                    prevNode.nextRight = node;
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
                prevNode = node;
            }else{
                System.out.println();
                prevNode.nextRight = null;
                prevNode = null;

                // Node was null
                // Check if the queue is empty if it is then break out of the loop
                // otherwise we will go in infinite loop
                if(queue.isEmpty()){
                    break;
                }
                queue.add(null);
            }
        }
        //System.out.println();
    }

}
