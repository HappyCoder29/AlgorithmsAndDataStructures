package edu.northeastern.ashish;


import java.util.ArrayList;
//https://leetcode.com/problems/sum-root-to-leaf-numbers/
public class BinaryTree <T> {
    public Node<T> root;

    public BinaryTree() {
    }

    public  ArrayList<String> getAllPaths(){
        ArrayList<String> listPaths = new ArrayList<>();


        ArrayList<T> list = new ArrayList<>();

        getAllPaths(root, list,listPaths, 0);

        return listPaths;

    }

    private  void getAllPaths(Node<T> node, ArrayList<T> list, ArrayList<String> listPaths, int ptr){
        if(node == null){
            return;
        }
        list.add(ptr, node.data);

        // If node == leaf we print out the entire list
        if(node.left == null && node.right == null){
            String path = "";
            for(int i = 0 ; i <= ptr; i ++){
                path += list.get(i).toString();
            }
            listPaths.add(path);
        }
        else{
            getAllPaths(node.left, list,listPaths, ptr + 1);
            getAllPaths(node.right, list,listPaths, ptr + 1);
        }
    }

}
