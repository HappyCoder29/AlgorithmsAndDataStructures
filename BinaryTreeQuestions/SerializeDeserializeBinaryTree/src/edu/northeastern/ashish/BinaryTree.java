package edu.northeastern.ashish;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree <T> {
    public Node<T> root;

    public BinaryTree() {

    }

    public void levelOrder() {
        if (root == null) {
            return;
        }
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (queue.isEmpty() == false) {
            Node<T> node = queue.remove();
            if (node != null) {
                System.out.print(node.data + ", ");
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            } else {
                System.out.println();

                // Node was null
                // Check if the queue is empty if it is then break out of the loop
                // otherwise we will go in infinite loop
                if (queue.isEmpty()) {
                    break;
                }
                queue.add(null);
            }
        }
        System.out.println();
    }



    public String serialize(){
      StringBuilder sb = new StringBuilder();
      serialize(root, sb);
      return sb.toString().substring(0,sb.toString().lastIndexOf(","));
    }

    private void serialize(Node<T> node, StringBuilder sb){
        if(node == null){
            sb.append("Null,");
            return;
        }
        sb.append(node.data + ",");
        serialize(node.left, sb);
        serialize(node.right, sb);

    }



    public Node<Integer> deSerialize(String str){
        String[] arr = str.split(",");
        BoxValue<Integer> box =new BoxValue<>(0);
        return deSerialize(arr, box);
    }

    private Node<Integer> deSerialize(String[] arr, BoxValue<Integer> box){
        String str = arr[box.data];
       // System.out.println(Integer.parseInt(arr[box.data]));
        System.out.println(box.data);
        if(str.equalsIgnoreCase("Null")){
            return null;
        }
        //System.out.println(Integer.parseInt(arr[box.data]));
        Node<Integer> node = new Node<>( Integer.parseInt(arr[box.data]) );
        box.data ++;
        node.left = deSerialize(arr, box);
        box.data ++;
        node.right = deSerialize(arr, box);
        return node;
    }

}
