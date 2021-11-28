package edu.northeastern.ashish;

import java.util.Stack;

public class BinaryTree <T> {
    public Node<T> root;

    public BinaryTree() {

    }


    public void boundary(){
        Stack<Node<T>> stack = new Stack<>();
        boundary(root, 0, 0 , stack);

        while(stack.size() > 0){
            System.out.print(stack.pop().data + ", ");
        }
        System.out.println();
    }

    private void boundary(Node<T> node, int left, int right, Stack<Node<T>> stack){
        if(node != null){
            // if it is leaf node
            if(node.left == null && node.right == null){
                System.out.print(node.data + ", ");
            } else if( right == 0){
                System.out.print(node.data + ", ");
            }else if (left == 0 ){
                stack.push(node);
            }

            boundary(node.left, left +1, right, stack);
            boundary(node.right, left, right + 1, stack);
        }
    }



}
