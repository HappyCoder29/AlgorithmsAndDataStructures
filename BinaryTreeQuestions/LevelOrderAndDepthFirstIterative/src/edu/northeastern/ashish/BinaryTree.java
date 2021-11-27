package edu.northeastern.ashish;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree <T>{
    /// region Class 1

    public Node<T> root;

    public BinaryTree(){
        this.root = null;
    }

    public void levelOrder(){
        if(root == null){
            return;
        }

        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while(!queue.isEmpty()){
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
                // There is a change of level
                System.out.println();
                if(queue.isEmpty()){
                    break;
                }
                queue.add(null);
            }
        }
    }// end of level order

    public void depthFirstIterative(){
        if(root == null){
            return;
        }

        Stack<Node<T>> stack = new Stack<>();
        stack.add(root);

        while(!stack.isEmpty()){
            Node<T> node = stack.pop();
            System.out.print(node.data + ", ");
            if(node.left != null){
                stack.push(node.left);
            }
            if(node.right != null){
                stack.push(node.right);
            }
        }
        System.out.println();

    }

}
