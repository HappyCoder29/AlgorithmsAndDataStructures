package edu.northeastern.ashish;

import java.util.ArrayList;

public class BST  {
    public Node root;

    public BST(){

    }

    public int findMaxOccuringValueInATree(){
        ArrayList<Integer> list = new ArrayList<>();
        getList(root, list);
        // We have all the elements in sorted order

    }

    private void  getList(Node node, ArrayList<Integer> list){
        if(node != null){
            getList(node.left, list);
            list.add(node.data);
            getList(node.left, list);

        }
    }

}
