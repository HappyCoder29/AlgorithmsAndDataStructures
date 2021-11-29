package edu.northeastern.ashish;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree <T> {
    public Node<T> root;

    public BinaryTree() {

    }

    public int size(){
        return  size(root);
    }
    private int size(Node<T> node){

        if(node == null){
            return 0;
        }

        return  1 + size(node.left) + size(node.right);
    }

    public void levelOrder(){
        if(root == null){
            return;
        }
        int size = size();
        int ptr = 0;

        LinkedList< Node<T> > list = new LinkedList<>();
        list.add(root);

        while( ptr < size ){
            Node<T> node = list.get(ptr);
            System.out.print(node.data + ", ");
            if(node.left != null){
                list.add(node.left);
            }
            if(node.right != null){
                list.add(node.right);
            }
            ptr ++;
        }
        Node<T> prev = null;
        for(int i = 0 ; i < size; i ++){
            list.get(i).left = prev;
            if(i +1 != size){
                list.get(i).right = list.get(i+1);
            }else{
                list.get(i).right = null;
            }
            prev = list.get(i);
        }
        this.root = list.get(0);
    }

}