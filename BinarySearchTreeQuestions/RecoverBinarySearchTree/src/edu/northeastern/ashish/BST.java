package edu.northeastern.ashish;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BST  {
    public Node root;

    public BST(){

    }

    public void inOrder(){
        inOrder(root);
        System.out.println();
    }
    private void inOrder(Node node){
        if(node != null){
            inOrder(node.left);
            System.out.print(node.data + ", ");
            inOrder(node.right);
        }
    }

    public void reverseInOrder(){
        reverseInOrder(root);
        System.out.println();
    }
    private void reverseInOrder(Node node){
        if(node != null){
            reverseInOrder(node.right);
            System.out.print(node.data + ", ");
            reverseInOrder(node.left);
        }
    }

    /// Level Order
    public void levelOrder(){
        if(root == null){
            return;
        }
        Queue< Node > queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while( queue.isEmpty() == false ){
            Node node = queue.remove();
            if(node != null){
                System.out.print(node.data + ", ");
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }else{
                System.out.println();

                // Node was null
                // Check if the queue is empty if it is then break out of the loop
                // otherwise we will go in infinite loop
                if(queue.isEmpty()){
                    break;
                }
                queue.add(null);
            }
        }
        System.out.println();
    }

    public  void recoverTree(){
        ArrayList<Integer> list = new ArrayList<>();
        getTreeNodesInAList(root, list);
        int[] swapIndexes = getSwapIndexes(list);
        if(swapIndexes[0] == -1){// there were no values which were swapped
            return;
        }
        // Make the list sorted in increasing order
        Integer temp = list.get(swapIndexes[0]);
        list.set(swapIndexes[0], list.get(swapIndexes[1]));
        list.set(swapIndexes[1], temp);
        // At this point list should be sorted
        // Just inorder traversal and keep setting values to whatever is in the list
        recoverTree(root, list, new BoxValue<Integer>(0));
        System.out.println();

    }

    private void recoverTree(Node node, ArrayList<Integer> list, BoxValue<Integer> currentIndex){
        if(node != null){
            recoverTree(node.left, list, currentIndex);
            node.data = list.get(currentIndex.data);
            currentIndex.data ++;
            recoverTree(node.right, list, currentIndex);
        }
    }


    public  void getTreeNodesInAList(Node node, ArrayList<Integer> list){
        if(node != null){
            getTreeNodesInAList(node.left, list);
            list.add(node.data);
            getTreeNodesInAList(node.right, list);
        }
    }

    public int[]  getSwapIndexes(ArrayList<Integer> list){
        int first = -1;
        int second = -1;
        for(int i = 0 ; i < list.size() -1; i ++){
            if(list.get(i) > list.get(i+1)){
                if(first == -1){
                    first = i;
                }else{
                    second = i+1;
                }
            }
        }

        if(first!= -1 && second == -1){
            second = first +1;
        }
        return new int[] {first, second};
    }

}
