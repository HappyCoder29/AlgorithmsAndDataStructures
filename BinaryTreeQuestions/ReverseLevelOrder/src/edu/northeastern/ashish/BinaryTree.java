package edu.northeastern.ashish;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
//https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
public class BinaryTree <T> {
    public Node<T> root;

    public BinaryTree() {

    }

    public ArrayList<ArrayList<Node<T>>> levelOrder() {
        if (root == null) {
            return null;
        }
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        Stack<ArrayList<Node<T>>>  stack = new Stack<>();
        ArrayList<Node<T>> list = new ArrayList<>();

        while (queue.isEmpty() == false) {
            Node<T> node = queue.remove();
            if (node != null) {
                list.add(node);
               // System.out.print(node.data + ", ");
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            } else {
                System.out.println();
                stack.push(list);


                // Node was null
                // Check if the queue is empty if it is then break out of the loop
                // otherwise we will go in infinite loop
                if (queue.isEmpty()) {
                    break;
                }
                list = new ArrayList<>();
                queue.add(null);
            }
        }

        ArrayList<ArrayList<Node<T>>> listLevelOrder = new ArrayList<>();
        while(!stack.isEmpty()){
            listLevelOrder.add(stack.pop());
        }
        return listLevelOrder;
    }
}
