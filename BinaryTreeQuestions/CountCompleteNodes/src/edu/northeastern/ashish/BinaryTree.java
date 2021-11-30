package edu.northeastern.ashish;


import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree <T> {
    public Node<T> root;

    public BinaryTree() {
    }

    public int depth(){
        return depth(root);
    }
    private int depth(Node<T> node){
        if(node == null ){
            return 0;
        }
        return  1 + Math.max(depth(node.left) ,depth(node.right));
    }

    public int countNodes(){
        BoxValue<Integer> box = new BoxValue<>(0);
         countNodes(root, box);
         return box.value;
    }
    private void countNodes(Node<T> node, BoxValue<Integer> box){
        if(node != null){
            box.value ++;
            countNodes(node.left, box);
            countNodes(node.right, box);

        }
    }

    public boolean isCompleteTree(){
        int maxDepth = depth();
        BoxValue<Boolean> boxIsComplete = new BoxValue<>(true);
        BoxValue<Boolean> boxEncounteredNull = new BoxValue<>(false);
        isCompleteTree(root, 1, maxDepth, boxIsComplete, boxEncounteredNull);

        return boxIsComplete.value;
    }

    private void isCompleteTree(Node<T> node, int depth, int maxDepth, BoxValue<Boolean> boxIsComplete, BoxValue<Boolean> boxEncounteredNull ){
        if(node != null){
            if(depth < maxDepth -1){
                // before the last -1 level all nodes should be complete nodes
                if(! (node.left != null && node.right != null)){
                    boxIsComplete.value = false;
                    return;// all nodes before last but one should be full
                }
            }
            else if(depth == maxDepth -1){
               checkForlastButOneDepth(node, boxIsComplete, boxEncounteredNull);
            }

            isCompleteTree(node.left, depth+1, maxDepth, boxIsComplete, boxEncounteredNull);
            isCompleteTree(node.right, depth+1, maxDepth, boxIsComplete, boxEncounteredNull);

        }
    }

    private void checkForlastButOneDepth(Node<T> node, BoxValue<Boolean> boxIsComplete, BoxValue<Boolean> boxEncounteredNull){

        // If right is not null and left is null then this is not complete tree
        if(node.right != null && node.left == null){
            boxIsComplete.value = false;
            return;
        }
        if(node.left == null && node.right == null){
            boxEncounteredNull.value = true;
            return;
        }

        if(node.left!= null && node.right != null){
            if( boxEncounteredNull.value == true){
                boxIsComplete.value = false;
                return;
            }

        }

        if(node.left!= null && node.right == null){
            if( boxEncounteredNull.value == true){
                boxIsComplete.value = false;
                return;
            }
            boxEncounteredNull.value = true;
        }
    }

    public boolean isCompleteLevelOrder(){
        if(root == null){
            return true;
        }
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        boolean encounteredNull = false;
        while(!queue.isEmpty()){
            Node<T> node = queue.remove();
            if(node == null){
                encounteredNull = true;
                continue;
            }
            if(encounteredNull == true){
                return false;
            }

            queue.add(node.left);
            queue.add(node.right);
        }
        return true;
    }

}

