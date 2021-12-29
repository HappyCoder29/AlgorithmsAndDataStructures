package edu.northeastern.ashish;

import java.util.ArrayList;

public class BST  {
    public Node root;

    public BST(){
    }

    public int minAbsoluteDifference(){
        if( root == null || ( root.left == null && root.right == null ) ){
            return Integer.MAX_VALUE;
        }
        ArrayList<Integer> list = new ArrayList<>();
        minAbsoluteDifference(root, list);
        Integer minDiff = Integer.MAX_VALUE;
        for(int i = 1; i < list.size(); i ++){
            int diff = Math.abs( list.get(i-1) - list.get(i));
            if(diff < minDiff){
                minDiff = diff;
            }
        }

        return minDiff;

    }
    public void minAbsoluteDifference(Node node, ArrayList<Integer> list){
        if(node != null){
            minAbsoluteDifference(node.left, list);
            list.add(node.data);
            minAbsoluteDifference(node.right, list);
        }
    }
}
