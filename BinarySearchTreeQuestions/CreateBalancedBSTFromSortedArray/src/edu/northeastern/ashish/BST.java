package edu.northeastern.ashish;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BST  {
    public Node root;

    public BST(){

    }

    public Node createBalancedBST(int[] arr){
        if(arr == null || arr.length == 0 ){
            return null;
        }
        return createBalancedBST(arr, 0, arr.length -1);
    }

    private Node createBalancedBST( int[] arr, int start, int end){
        if(start > end){
            return null;
        }
        int mid = (start + end)/2;
        Node node = new Node(arr[mid]);
        node.left = createBalancedBST(arr, start, mid-1);
        node.right = createBalancedBST(arr, mid + 1, end);
        return node;
    }

    public Node createBalancedBST(ArrayList<Integer> list){
        if(list == null || list.size() == 0 ){
            return null;
        }
        return createBalancedBST(list, 0, list.size() -1);
    }

    private Node createBalancedBST( ArrayList<Integer> list, int start, int end){
        if(start > end){
            return null;
        }
        int mid = (start + end)/2;
        Node node = new Node(list.get(mid));
        node.left = createBalancedBST(list, start, mid-1);
        node.right = createBalancedBST(list, mid + 1, end);
        return node;
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
