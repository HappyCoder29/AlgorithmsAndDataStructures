package edu.northeastern.ashish;

import java.util.ArrayList;

public class BST  {
    public Node root;

    public BST(){

    }

    public boolean isValidBST(){
        Integer low = null;
        Integer high = null;
        return isValidBST(root, null, null);

    }

    private boolean isValidBST(Node node, Integer low, Integer high){
        if(node == null){
            return true;
        }

        if( (high != null &&  node.data > high) || ( low != null && node.data < low )) {
            return false;
        }

        return  isValidBST( node.left,  low, node.data) && isValidBST( node.right,  node.data, high);
    }


}
