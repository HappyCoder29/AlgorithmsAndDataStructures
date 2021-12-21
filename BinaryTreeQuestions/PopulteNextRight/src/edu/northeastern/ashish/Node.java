package edu.northeastern.ashish;


public class Node <T>{
    public Node<T> left;
    public Node<T> right;
    public Node<T> nextRight;
    public Node<T> nextLeft;
    public T data;

    public Node(T data){
        this.data = data;
    }
}


