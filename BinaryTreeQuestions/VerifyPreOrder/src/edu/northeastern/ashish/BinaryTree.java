package edu.northeastern.ashish;

public class BinaryTree <T> {
    public Node<T> root;

    public BinaryTree() {

    }

    public void preOrder(){
        preOrder(root);
        System.out.println();
    }
    private void preOrder(Node<T> node){
        if(node != null){
            System.out.print(node.data + ",");
            preOrder(node.left);
            preOrder(node.right);

        }
    }

    public boolean verifyPreOrder(int[] arr){
        BoxValue<Integer> ptr = new BoxValue<>(0);
        BoxValue<Boolean> isPreOrder = new BoxValue<>(true);

        verifyPreOrder(root, arr,  ptr, isPreOrder );
        return isPreOrder.val;

    }

    private void verifyPreOrder(Node<T> node, int[]  arr, BoxValue<Integer> ptr, BoxValue<Boolean> isPreOrder ){
        if(node != null){

            if(isPreOrder.val == false){
                return;
            }

            if((Integer)node.data !=  arr[ptr.val]){
                isPreOrder.val = false;
                return;
            }
            ptr.val++;

            verifyPreOrder(node.left, arr, ptr, isPreOrder);
            verifyPreOrder(node.right, arr, ptr, isPreOrder);

        }
    }

}
