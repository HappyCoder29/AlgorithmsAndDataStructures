package edu.northeastern.ashish;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree <T> {
    public Node<T> root;

    public BinaryTree() {

    }

    public void printZigZag(){
        if(root == null){
            return;
        }
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        boolean bPrint = true;
        Stack<Node<T>> stack = new Stack<>();

        while(!queue.isEmpty()){
            Node<T> node = queue.remove();

            if(node != null){
                if(bPrint == true){
                    System.out.print(node.data + ", ");
                }else{
                    stack.push(node);
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }else{
                bPrint = !bPrint;

                // if there are elements in stack print them
                while(!stack.isEmpty()){
                    System.out.print(stack.pop().data + ", ");
                }
                System.out.println();
                if(queue.isEmpty()){
                    break;
                }
                queue.add(null);

            }
        }// end of while
    }// end of function
}
