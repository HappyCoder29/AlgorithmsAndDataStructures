package edu.northeastern.ashish;


import java.util.ArrayList;

public class BSTIterator {
    private ArrayList<Integer> list;
    private int currentIndex = -1;

    public BSTIterator(Node node) {
        populateList(node);
    }

    private void populateList(Node node){
        list = new ArrayList<>();
        populateList(node, list);
        currentIndex = 0;
    }
    private void populateList(Node node, ArrayList<Integer> list){
        if(node != null){
            populateList(node.left, list );
            list.add(node.data);
            populateList(node.left, list );
        }
    }

    public int next() {
        if(currentIndex == list.size() ){
            return Integer.MIN_VALUE;
        }
        return list.get(currentIndex++);
    }

    public boolean hasNext() {
        if(currentIndex == -1 || currentIndex == list.size()){
            return false;
        }
        return true;
    }

    public int previous() {
        if(currentIndex < 0 ){
            return Integer.MIN_VALUE;
        }
        return list.get(currentIndex--);
    }

    public boolean hasPrevious() {
        if(currentIndex <= 0){
            return false;
        }
        return true;
    }
}