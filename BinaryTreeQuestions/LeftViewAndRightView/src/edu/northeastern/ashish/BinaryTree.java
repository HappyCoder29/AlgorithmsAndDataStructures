package edu.northeastern.ashish;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree <T>{
    /// region Class 1

    public Node<T> root;

    public BinaryTree(){
        this.root = null;
    }


    public void printLeftView(){
        if(root == null){
            return;
        }
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        boolean bPrint = true;

        while(!queue.isEmpty()){
            Node<T> node = queue.remove();
            if(node != null){
                if(bPrint == true){
                    System.out.println(node.data);
                    bPrint = false;
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }else{
                if(queue.isEmpty()){
                    break;
                }
                bPrint = true;
                queue.add(null);
            }
        }// end of while
    }// end of function


    public void printRightView(){
        if(root == null){
            return;
        }
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        Node<T> lastNode = null;
        while(!queue.isEmpty()){
            Node<T> node = queue.remove();
            if(node != null){
                lastNode = node;
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }else{
                System.out.println(lastNode.data);
                if(queue.isEmpty()){
                    break;
                }
                queue.add(null);
            }
        }// end of while

    }// end of function

}
