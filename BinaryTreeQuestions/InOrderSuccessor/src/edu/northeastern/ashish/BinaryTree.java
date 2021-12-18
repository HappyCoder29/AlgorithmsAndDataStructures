package edu.northeastern.ashish;

import java.util.ArrayList;

public class BinaryTree <T> {
    public Node<T> root;

    public BinaryTree() {

    }

    private  Node<T> getMinimumNode(Node<T> node){
        if(node == null){
            return null;
        }

        Node<T> temp = node;
        while(temp.left != null){
            temp = temp.left;
        }
        return temp;
    }

    public Node<T> inOrderSuccessor(Node<T> nodeValue){
        if(nodeValue == null){
            return null;
        }
        BoxValue<Boolean> boxFound = new BoxValue<>(false);
        BoxValue<Node<T>> boxSuccessor = new BoxValue<>(null);
        inOrderSuccessor(root, nodeValue, boxFound, boxSuccessor);

        return boxSuccessor.value;


    }

    public void inOrderSuccessor(Node<T> node, Node<T> nodeValue, BoxValue<Boolean> boxFound, BoxValue<Node<T>> boxSuccessor ){
        if(node != null){
            inOrderSuccessor(node.left, nodeValue, boxFound, boxSuccessor);

            if(boxFound.value == true && boxSuccessor.value != null){
                return;
            }

            if(boxFound.value == true && boxSuccessor.value == null){
                boxSuccessor.value = node;
                return;
            }
            if(node.data.equals(nodeValue.data)){
                boxFound.value = true;
                if(node.right != null){
                    boxSuccessor.value = getMinimumNode(node.right);
                }
            }
            inOrderSuccessor(node.right, nodeValue, boxFound, boxSuccessor);

        }
    }


    // O(n) Space O(n)
    public Node<T> inOrderSuccessorWithList(Node<T> nodeValue){

        if(nodeValue == null){
            return null;
        }
        ArrayList<Node<T>> list = new ArrayList<>();

        inOrderProcessing(root, nodeValue, list);
        int index = list.indexOf(nodeValue);
        if(index == -1){
            return null;
        }
        if(index == list.size() -1){
            return null;
        }
        return  list.get(index + 1);

    }

    // O(n) Space O(n)

    public Node<T> inOrderPredessorWithList(Node<T> nodeValue){

        if(nodeValue == null){
            return null;
        }
        ArrayList<Node<T>> list = new ArrayList<>();

        inOrderProcessing(root, nodeValue, list);
        int index = list.indexOf(nodeValue);
        if(index == -1){
            return null;
        }
        if(index == 0){
            return null;
        }
        return  list.get(index - 1);

    }



    public void inOrderProcessing(Node<T> node, Node<T> nodeValue,  ArrayList<Node<T>> list){

        if(node != null) {
            inOrderProcessing(node.left, nodeValue, list);
            list.add(node);
            inOrderProcessing(node.right, nodeValue, list);
        }

    }


    public void preOrderProcessing(Node<T> node, Node<T> nodeValue,  ArrayList<Node<T>> list){

        if(node != null) {
            list.add(node);
            preOrderProcessing(node.left, nodeValue, list);
            preOrderProcessing(node.right, nodeValue, list);
        }

    }

    public void postOrderProcessing(Node<T> node, Node<T> nodeValue,  ArrayList<Node<T>> list){

        if(node != null) {
            postOrderProcessing(node.left, nodeValue, list);
            postOrderProcessing(node.right, nodeValue, list);
            list.add(node);
        }

    }



}
