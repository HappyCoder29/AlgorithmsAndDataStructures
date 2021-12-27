package edu.northeastern.ashish;

public class BST  {
    public Node root;

    public BST(){

    }

    public void preOrder(){
        preOrder(root);
        System.out.println();
    }
    private void preOrder(Node node){
        if(node != null){
            System.out.print(node.data + ", ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }



    public boolean verifyPreOrder(int[] arr){
        BoxValue<Integer> currentIndex = new BoxValue<>(0);
        BoxValue<Boolean> isPreOrder = new BoxValue<>(true);
        verifyPreOrder(root, arr, currentIndex, isPreOrder);
        return isPreOrder.data;
    }

    public void verifyPreOrder(Node node, int[] arr, BoxValue<Integer> currentIndex, BoxValue<Boolean> isPreOrder){
        if(node != null && isPreOrder.data == true){
            if(node.data != arr[currentIndex.data]){
                isPreOrder.data = false;
                return;
            }
            currentIndex.data++;
            verifyPreOrder(node.left, arr, currentIndex, isPreOrder);
            verifyPreOrder(node.right, arr, currentIndex, isPreOrder);
        }
    }


}
