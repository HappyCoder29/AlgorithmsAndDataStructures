package edu.northeastern.ashish;

public class BinaryTree <T> {
    public Node<T> root;

    public BinaryTree() {

    }

    public int countUniValues(){
        BoxValue<Integer> uniValues = new BoxValue<>(0);
        countUniValues(root, uniValues);
        return uniValues.value;
    }
    private boolean countUniValues(Node<T> node, BoxValue<Integer> uniValues){


            if (node.left == null && node.right == null) {
                uniValues.value++;
            }
            boolean is_unival = true;

            // check if all of the node's children are univalue subtrees and if they have the same value
            // also recursively call is_uni for children
            if (node.left != null) {
                is_unival = countUniValues(node.left, uniValues) && is_unival && node.left.data == node.data;
            }

            if (node.right != null) {
                is_unival = countUniValues(node.right, uniValues) && is_unival && node.right.data == node.data;
            }

            // return if a univalue tree exists here and increment if it does
            if (!is_unival) return false;
            uniValues.value++;
            return true;
        }

}
