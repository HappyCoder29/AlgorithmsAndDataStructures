package edu.northeastern.ashish;

import javax.swing.*;

public class BST  {
    public Node root;

    public BST(){

    }

    public int findClosestValue(int target){
        BoxValue<Integer>  closestValue = new BoxValue<>(Integer.MAX_VALUE);
        BoxValue<Integer>  currentDifference = new BoxValue<>(Integer.MAX_VALUE);

        findClosestValue(root, target, closestValue, currentDifference);
        return closestValue.data;
    }

    private void findClosestValue(Node node, int target, BoxValue<Integer> closestValue, BoxValue<Integer>  currentDifference ){
        if(node != null){
            findClosestValue(node.left, target, closestValue, currentDifference);
//            System.out.println(Math.abs(target - node.data));
//            System.out.println("Node = " + node.data);

            if(Math.abs(target - node.data) < currentDifference.data){
                closestValue.data = node.data;
                currentDifference.data = Math.abs(target - node.data);
            }
            findClosestValue(node.right, target, closestValue, currentDifference);
        }

    }

}
