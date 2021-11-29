package edu.northeastern.ashish;

public class BinaryTree <T> {

    public Node<T> root;

    public BinaryTree() {

    }

    public  int sumMaxPath(){
        BoxValue box = new BoxValue(0);
        sumMaxPath(root, box);
        return box.value;

    }
    public int sumMaxPath(Node<T> node, BoxValue box){
        if(node == null){
            return 0;
        }

        int left = sumMaxPath(node.left, box);
        int right = sumMaxPath(node.right, box);

        int val = (Integer)node.data + left +  right;

        if(box.value < val){
            box.value = val;
        }
        return (Integer)node.data + Math.max(left, right);

    }
}
