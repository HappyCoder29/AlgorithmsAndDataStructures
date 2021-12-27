package edu.northeastern.ashish;

import javax.swing.*;

public class BST  {
    public Node root;

    public BST(){

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


    public Integer getKThSmallestValue(int k){
        if(root == null|| k <=0){
            return Integer.MIN_VALUE;
        }

        BoxValue<Integer> box = new BoxValue<>(k);
        BoxValue<Integer> returnValue = new BoxValue<>(Integer.MIN_VALUE);

        getKThSmallestValue(root, box, returnValue);
        return returnValue.data;

    }
    public void getKThSmallestValue(Node node, BoxValue<Integer> box, BoxValue<Integer> returnValue){
        if(node != null){
            getKThSmallestValue(node.right, box, returnValue);
            box.data--;
            if(box.data == 0){
                System.out.println("Kth smallest value = " + node.data);
                returnValue.data = node.data;
                return;
            }
            getKThSmallestValue(node.left, box, returnValue);

        }
    }
}
