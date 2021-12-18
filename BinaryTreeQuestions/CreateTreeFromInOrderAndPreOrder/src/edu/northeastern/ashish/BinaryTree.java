package edu.northeastern.ashish;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree <T> {
    public Node<T> root;

    public BinaryTree() {

    }

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

    private int findIndex(T[] arr, int start, int end, int value){
        if(start == end  && arr[start].equals(value)){
            return start;
        }
        for(int i = start; i < end ; i ++){
            if(arr[i].equals(value)){
                return i;
            }
        }
        return -1;
    }

    private int findIndex(T[] arr, int value){

        for(int i = 0; i < arr.length ; i ++){
            if(arr[i].equals(value)){
                return i;
            }
        }
        return -1;
    }

    public Node<T> constructTreeFromInOrderAndPreOrder(T[] inOrder, T[] preOrder){
        BoxValue<Integer> preIndex = new BoxValue<>(0);
        return  getTreeFromPreAndInOrder(inOrder, preOrder, preIndex, 0, inOrder.length  -1);
    }



    private Node<T>getTreeFromPreAndInOrder(T[] inOrder, T[] preOrder, BoxValue<Integer> preIndex, int start, int end){
        if(start >  end || preIndex.value >= preOrder.length){
            return null;
        }
        Node<T> node = new Node<T>(preOrder[preIndex.value]);
        preIndex.value ++;

        int inOrderIndex = findIndex(inOrder, start, end, (Integer) node.data);

        node.left = getTreeFromPreAndInOrder(inOrder, preOrder, preIndex, start, inOrderIndex -1);
        node.right = getTreeFromPreAndInOrder(inOrder, preOrder, preIndex, inOrderIndex+1 , end);

        return node;

    }
}
