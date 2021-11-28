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
        if(node == null){
            return;
        }
        list.add(ptr, node.data);

        // If node == leaf we print out the entire list
        if(node.left == null && node.right == null){
            for(int i = 0 ; i <= ptr; i ++){
                System.out.print(list.get(i) + ", ");
            }
            System.out.println();
        }
        else{
            printAllRootToLeaf(node.left, list, ptr + 1);
            printAllRootToLeaf(node.right, list, ptr + 1);
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
        BoxValue<ArrayList<ArrayList<T>>> box = new BoxValue<>(allLists);

        allPathSum(root, list, box, 0, sum);

        return box.value;
    }

    public void allPathSum(Node<T> node, ArrayList<T> list, BoxValue<ArrayList<ArrayList<T>>> box,  int ptr, int sum ){
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
            box.value.add(lst);
        }
        else{
            allPathSum(node.left, list, box, ptr + 1, sum - (Integer)node.data);
            allPathSum(node.right, list,box,  ptr + 1, sum - (Integer)node.data);
        }
    }

    public int maxPathSum(){

    }

}
