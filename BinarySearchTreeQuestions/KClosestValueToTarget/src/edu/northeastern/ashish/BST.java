package edu.northeastern.ashish;

import java.util.ArrayList;

public class BST  {
    public Node root;

    public BST(){

    }

    public ArrayList<Integer> getKClosestValues(int k, Float target){
        ArrayList<Integer> list = new ArrayList<>();
        getAllNodes(root, list);

        if(k >= list.size()){
            return list;
        }
        ArrayList<Integer> returnList = new ArrayList<>();
        int index = getIndexClosestToTarget(list, target);
        returnList.add(list.get(index));
        int leftIndex = index-1;
        int rightIndex = index +1;

        while( returnList.size() < k){
            if(leftIndex < 0){
                while(returnList.size() < k){
                    returnList.add(list.get(rightIndex++));
                }
            }
            if(rightIndex >= list.size()){
                while(returnList.size() < k){
                    returnList.add(list.get(leftIndex--));
                }
            }

            if( Math.abs(target - list.get(leftIndex)) < Math.abs(target - list.get(rightIndex)) ){
                returnList.add(list.get(leftIndex));
                leftIndex --;
            }else{
                returnList.add(list.get(rightIndex));
                rightIndex ++;
            }
        }

        return returnList;
    }

    private void getAllNodes(Node node, ArrayList<Integer> list){
        if(node != null){
            getAllNodes(node.left, list);
            list.add(node.data);
            getAllNodes(node.right, list);
        }
    }

    private int getIndexClosestToTarget(ArrayList<Integer> list, Float target){
        if(target < list.get(0)){
            return 0;
        }
        if(target > list.get(list.size() -1)){
            return list.size() -1;
        }

        float diff = Integer.MAX_VALUE;
        int index = -1;

        for(int i = 0 ; i < list.size(); i ++){
            if(Math.abs(target-list.get(i)) < diff){
                index = i;
                diff = Math.abs(target-list.get(i));
            }
        }

        return index;

    }

}
