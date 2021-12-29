package edu.northeastern.ashish;

import java.util.Comparator;

public class BST  {
    public Node root;

    public BST(){

    }

    public void deleteNode(int data){
       root = deleteNode(root, data);
    }
    public Node deleteNode(Node node, int data ){
        if(node == null){
            return null;
        }
        if(node.data < data){
            return deleteNode(node.left, data);
        }else if (node.data >  data){
            return deleteNode(node.right, data);
        }else{
            // either one or both child are null
            if(node.left == null){
                return node.right;
            }
            else if(node.right == null){
                return node.left;
            }

            // Node has both left asd well as right node
            // Get Min node on the right and assign its value to current node
            node.data = getMinNode(node.right).data;
            node.right = deleteNode(node.right, node.data);
        }
        return node;
    }

    private Node getMinNode(Node node){
        if(node == null){
            return  null;
        }
        Node current = node;
        while(current.left != null){
            current = current.left;
        }
        return current;
    }

}
