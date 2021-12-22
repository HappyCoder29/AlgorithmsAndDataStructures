package edu.northeastern.ashish;

public class BinaryTree <T> {
    public Node<T> root;

    public BinaryTree() {

    }

    public int getLongestConsecutive(){
        BoxValue<Integer> box = new BoxValue<>(0);
        getLongestConsecutive(root, null, 0,box );
        return box.value;

    }

    private void getLongestConsecutive(Node<T> node, Node<T> parent, int length, BoxValue<Integer> box){
        if(node != null){
            if(parent != null && (Integer) parent.data + 1 == (Integer) node.data  ){
                length = length +1;
            }else{
                length = 1;
            }
            if(box.value < length){
                box.value = length;
            }

            getLongestConsecutive(node.left, node, length, box);
            getLongestConsecutive(node.right, node, length, box);
        }
    }

}
