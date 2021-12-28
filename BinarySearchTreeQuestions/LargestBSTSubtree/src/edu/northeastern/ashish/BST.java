package edu.northeastern.ashish;

public class BST  {
    public Node root;

    public BST(){

    }


    public Node  findLargestBSTNode(){
        BoxValue<Node> boxNode = new BoxValue<>(null);
        BoxValue<Integer> boxCount = new BoxValue<>(Integer.MIN_VALUE);

        findLargestBSTNode(root, boxNode, boxCount);
        return boxNode.data;
    }

    private void findLargestBSTNode(Node node, BoxValue<Node> boxNode,BoxValue<Integer> boxCount ){
        if(node != null){
            if(isValidBST(node, null, null)){
                int count = count(node);
                if(boxCount.data < count){
                    boxCount.data = count;
                    boxNode.data = node;
                }
            }
            findLargestBSTNode(node.left, boxNode, boxCount);
            findLargestBSTNode(node.right, boxNode, boxCount);
        }



    }

    public int  findLargestBST(){
       return findLargestBST(root);
    }

    private int findLargestBST(Node node){
        if(node == null){
            return 0;
        }

        if(isValidBST(node, null, null)){
            return count(node);
        }
        else{
            return Math.max(findLargestBST(node.left), findLargestBST(node.right));
        }

    }

    public boolean isValidBST(){
        Integer low = null;
        Integer high = null;
        return isValidBST(root, null, null);

    }

    private boolean isValidBST(Node node, Integer low, Integer high){
        if(node == null){
            return true;
        }

        if( (high != null &&  node.data > high) || ( low != null && node.data < low )) {
            return false;
        }

        return  isValidBST( node.left,  low, node.data) && isValidBST( node.right,  node.data, high);
    }

    private int count(Node node){
        if(node == null){
            return 0;
        }
        return 1 + count(node.left) + count(node.right);
    }


}

