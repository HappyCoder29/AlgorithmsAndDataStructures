package edu.northeastern.ashish;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BST  {
    public Node root;

    public BST(){
    }

    public void convertToGreaterSum(){
        if( root == null || ( root.left == null && root.right == null ) ){
            return;
        }
        ArrayList<Integer> list = new ArrayList<>();
        getListOfNodes(root, list);
        int sum = 0;

        for(int i = list.size()-1; i >= 0 ; i --){
            list.set(i, list.get(i) + sum);
            sum = list.get(i);
        }
        BoxValue<Integer> index = new BoxValue<>(0);

        populateNodes(root, list, index);

    }
    private void getListOfNodes(Node node, ArrayList<Integer> list){
        if(node != null){
            getListOfNodes(node.left, list);
            list.add(node.data);
            getListOfNodes(node.right, list);
        }
    }

    private void populateNodes(Node node, ArrayList<Integer> list, BoxValue<Integer> index){
        if(node != null){
            populateNodes(node.left, list, index);
            node.data = list.get(index.data);
            index.data++;
            populateNodes(node.right, list, index);
        }
    }

    public void inOrder(){
        inOrder(root);
        System.out.println();
    }
    private void inOrder(Node node){
        if(node != null){
            inOrder(node.left);
            System.out.print(node.data + ", ");
            inOrder(node.right);
        }
    }

    /// Level Order
    public void levelOrder(){
        if(root == null){
            return;
        }
        Queue< Node > queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while( queue.isEmpty() == false ){
            Node node = queue.remove();
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
}
