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



    //O(2n) ~ O(n)
    public void flattenTreeInPreOrder(){
        if(root == null){
            return;
        }
        LinkedList< Node<T> > list = new LinkedList<>();
        BoxValue box = new BoxValue(0);
        flattenTreeInPreOrder(root, list, box); //O(n)
        Node<T> prev = null;
        for(int i = 0 ; i < list.size(); i ++){ //O(n)
            list.get(i).left = prev;
            if(i +1 != list.size()){
                list.get(i).right = list.get(i+1);
            }else{
                list.get(i).right = null;
            }
            prev = list.get(i);
        }
        this.root = list.get(0);
        System.out.println();
    }

    private void flattenTreeInPreOrder(Node<T> node, LinkedList<Node<T>> list, BoxValue box){
        if(node != null){
            list.add(box.value, node);
            box.value ++;
            flattenTreeInPreOrder(node.left, list, box);
            flattenTreeInPreOrder(node.right, list, box);
        }
    }


    // O(3(n) ~ O(n)  Space is O(n)
    public void flattenTreeInlevelOrder(){
        if(root == null){
            return;
        }
        int size = size(); // O(n)
        int ptr = 0;

        LinkedList< Node<T> > list = new LinkedList<>();
        list.add(root);

        while( ptr < size ){ // O(n) This can be made to O(1)
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
        for(int i = 0 ; i < size; i ++){ //O(n)
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