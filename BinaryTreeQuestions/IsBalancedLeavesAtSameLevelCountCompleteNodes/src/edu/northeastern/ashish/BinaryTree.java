package edu.northeastern.ashish;

public class BinaryTree <T> {
    public Node<T> root;

    public BinaryTree() {
    }

    public int height(){
        return height(root);
    }

    private int height(Node<T> node){
        if(node == null){
            return 0;
        }
        return 1 + height(node.left) + height(node.right);
    }

    public boolean  isBalanced(){
        return isBalanced(root);
    }
    private boolean isBalanced(Node<T> node){
        if(node == null){
            return true;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        boolean balanced = Math.abs(leftHeight - rightHeight) <= 1;

        return balanced && isBalanced(node.left) && isBalanced(node.right);

    }

    public boolean areAllLeavesAtSameLevel(){
        BoxValue<Integer> box = new BoxValue<>(Integer.MIN_VALUE);
        return areAllLeavesAtSameLevel(root, box, 1);
    }

    private boolean areAllLeavesAtSameLevel(Node<T> node, BoxValue<Integer> box, int height ){

        if(node == null){
            return true;
        }
        if(node.left == null && node.right == null){
            if(box.value == Integer.MIN_VALUE){
                box.value = height;
            }else{
                return box.value == height;
            }
        }
        return  areAllLeavesAtSameLevel( node.left, box, height + 1) &&
                areAllLeavesAtSameLevel( node.right, box, height + 1);
    }

    public int countNumberOfLeafNodes(){
        BoxValue<Integer> box = new BoxValue<>(0);
        countNumberOfLeafNodes(root, box);
        return box.value;
    }

    private void countNumberOfLeafNodes(Node<T> node, BoxValue<Integer> box){
        if(node != null){
            if(node.left != null && node.right != null){
                box.value ++;
            }
            countNumberOfLeafNodes(node.left, box);
            countNumberOfLeafNodes(node.right, box);

        }

    }



}
