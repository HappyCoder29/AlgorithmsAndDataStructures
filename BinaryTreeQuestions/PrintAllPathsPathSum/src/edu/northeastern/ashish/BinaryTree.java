package edu.northeastern.ashish;

import java.util.ArrayList;

public class BinaryTree <T> {
    public Node<T> root;

    public BinaryTree() {

    }

    public  void printAllRootToLeaf(){
        ArrayList<T> list = new ArrayList<>();

        printAllRootToLeaf(root, list, 0);
    }

    private  void printAllRootToLeaf(Node<T> node, ArrayList<T> list, int ptr){
        if(node != null) {
            list.add(ptr, node.data);
            // If node == leaf we print out the entire list
            if (node.left == null && node.right == null) {
                for (int i = 0; i <= ptr; i++) {
                    System.out.print(list.get(i) + ", ");
                }
                System.out.println();
                return;
            }
            printAllRootToLeaf(node.left, list, ptr + 1);
            printAllRootToLeaf(node.right, list, ptr + 1);
        }
    }


    public  ArrayList<ArrayList<T>> getAllRootToLeaf(){

        ArrayList<ArrayList<T>> returnList = new ArrayList<>();
        ArrayList<T> list = new ArrayList<>();

        getAllRootToLeaf(root, list, 0, returnList);
        return returnList;
    }

    private  void getAllRootToLeaf(Node<T> node, ArrayList<T> list, int ptr, ArrayList<ArrayList<T>> returnList){
        if(node != null) {
            list.add(ptr, node.data);
            // If node == leaf we print out the entire list
            if (node.left == null && node.right == null) {
                ArrayList<T> lst = new ArrayList<>();
                for (int i = 0; i <= ptr; i++) {
                    lst.add(i,list.get(i));
                   // System.out.print(list.get(i) + ", ");
                }
                returnList.add(lst);
                return;
            }
            getAllRootToLeaf(node.left, list, ptr + 1, returnList);
            getAllRootToLeaf(node.right, list, ptr + 1, returnList);
        }
    }



    public  boolean hasPathSum( int sum){
        return hasPathSum(root, sum);
    }
    private  boolean hasPathSum(Node<T> node, int sum){
        if(node == null){
            return  sum == 0 ;
        }

        return  hasPathSum(node.left, sum - (Integer)node.data) || hasPathSum(node.right, sum - (Integer)node.data);

    }

    public ArrayList<ArrayList<T>> allPathSum(int sum ){
        ArrayList<T> list = new ArrayList<>();
        ArrayList<ArrayList<T>> allLists = new ArrayList<>();
       // BoxValue<ArrayList<ArrayList<T>>> box = new BoxValue<>(allLists);

        allPathSum(root, list, allLists, 0, sum);

        return allLists;
    }

    public void allPathSum(Node<T> node, ArrayList<T> list, ArrayList<ArrayList<T>> allLists,  int ptr, int sum ){
        if(node == null){
            return;
        }
        list.add(ptr, node.data);

        // If node == leaf we print out the entire list
        if(node.left == null && node.right == null && sum - (Integer) node.data == 0){
            ArrayList<T> lst = new ArrayList<>();
            for(int i = 0 ; i <= ptr; i ++){
                lst.add(list.get(i));
            }
            allLists.add(lst);
        }
        else{
            allPathSum(node.left, list, allLists, ptr + 1, sum - (Integer)node.data);
            allPathSum(node.right, list,allLists,  ptr + 1, sum - (Integer)node.data);
        }
    }


    public  int maxPathSum(){
        ArrayList<T> list = new ArrayList<>();
        BoxValue<Integer> maxSum = new BoxValue<>(0);

        maxPathSum(root, list, 0, maxSum);
        return maxSum.value;
    }

    private  void maxPathSum(Node<T> node, ArrayList<T> list, int ptr, BoxValue<Integer> maxSum){
        if(node != null) {
            list.add(ptr, node.data);
            // If node == leaf we print out the entire list
            if (node.left == null && node.right == null) {
                Integer sum = 0;
                for (int i = 0; i <= ptr; i++) {
                    sum += (Integer) list.get(i);
                }
                if(sum > maxSum.value){
                    maxSum.value = sum;
                }
                return;
            }
            maxPathSum(node.left, list, ptr + 1, maxSum);
            maxPathSum(node.right, list, ptr + 1, maxSum);
        }
    }

    public int getMaxPathSum(){
        BoxValue<Integer> maxSum = new BoxValue<>(0);

        int val = getMaxPathSum(root, maxSum);
        return maxSum.value;


    }

    private int getMaxPathSum(Node<T> node, BoxValue<Integer> maxSum){
        if(node == null){
            return 0;
        }

        int leftSum = Math.max(getMaxPathSum(node.left, maxSum), 0);
        int rightSum = Math.max(getMaxPathSum(node.right, maxSum), 0);
        int maxAtThisLevel = (Integer)node.data + leftSum + rightSum;
        if(maxSum.value < maxAtThisLevel){
            maxSum.value = maxAtThisLevel;
        }

        return (Integer)node.data + Math.max(leftSum, rightSum);

    }







}
