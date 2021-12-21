package edu.northeastern.ashish;

import java.util.HashMap;
import java.util.HashSet;

public class BinaryTree <T> {
    public Node<T> root;

    public BinaryTree() {

    }

    public Node<T> lowestCommonAncestorWithParent(Node<T> node1 , Node<T> node2){

        HashSet<Node<T>> set = new HashSet<>();

        while(node1 != null || node2 != null){
            if(set.contains(node1)){
                return node1;
            }
            if(set.contains(node2)){
                return node2;
            }

            if(node1 != null){
                set.add(node1);
                node1 = node1.parent;
            }
            if(node2 != null){
                set.add(node2);
                node2 = node2.parent;
            }

        }
        return  null;

    }

    public Node<T> lowestCommonAncestorBST(Node<T> node1 , Node<T> node2){
        return lowestCommonAncestorBST(root, node1, node2);
    }

    private Node<T> lowestCommonAncestorBST(Node<T> node, Node<T> node1 , Node<T> node2){

        if(node.data == node1.data){
            return node1;
        }
        if(node.data == node2.data){
            return node2;
        }

        if(     ((Integer)node.data > (Integer)node1.data && (Integer)node.data < (Integer)node2.data) ||
                ((Integer)node.data < (Integer)node1.data && (Integer)node.data > (Integer)node2.data) ){
            return node;
        }

        if( (Integer)node.data > (Integer)node1.data && (Integer)node.data > (Integer)node2.data){
            return lowestCommonAncestorBST(node.left, node1, node2);
        }else
        {
            return lowestCommonAncestorBST(node.right, node1, node2);
        }

    }

    public Node<T> lowestCommonAncestorBSTIterative( Node<T> node1 , Node<T> node2){
        return lowestCommonAncestorBSTIterative(root, node1, node2);
    }

    private Node<T> lowestCommonAncestorBSTIterative(Node<T> node, Node<T> node1 , Node<T> node2){

        while(node != null){
            if(node.data == node1.data){
                return node1;
            }
            if(node.data == node2.data){
                return node2;
            }
            if(     ((Integer)node.data > (Integer)node1.data && (Integer)node.data < (Integer)node2.data) ||
                    ((Integer)node.data < (Integer)node1.data && (Integer)node.data > (Integer)node2.data) ){
                return node;
            }

            if( (Integer)node.data > (Integer)node1.data && (Integer)node.data > (Integer)node2.data){
                node = node.left;
            }else
            {
                node = node.right;
            }
        }

        return null;
    }


    public Node<T> lowestCommonAncestor(Node<T> node1, Node<T> node2){
        return lowestCommonAncestor(root, node1, node2);
    }

    public Node<T> lowestCommonAncestor(Node<T> node, Node<T> node1, Node<T> node2){

        if(node == null){
            return null;
        }
        if(node == node1){
            return node1;
        }
        if(node == node2){
            return node2;
        }

        Node<T> left = lowestCommonAncestor(node.left, node1, node2);
        Node<T> right = lowestCommonAncestor(node.right, node1, node2);

        if(left != null && right != null){
            return node;
        }

        if(left != null){
            return left;
        }
        else{
            return right;
        }
    }


}
