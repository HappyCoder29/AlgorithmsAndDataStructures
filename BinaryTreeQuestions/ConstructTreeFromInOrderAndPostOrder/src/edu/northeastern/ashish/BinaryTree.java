package edu.northeastern.ashish;

import java.util.LinkedList;
import java.util.Queue;
//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
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

    private int findIndex(T[] arr, int start, int end, int value) {
        if (start == end && arr[start].equals(value)) {
            return start;
        }
        for (int i = start; i < end; i++) {
            if (arr[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public Node<T> constructTreeFromInOrderAndPostOrder(T[] inOrder, T[] postOrder) {

        BoxValue<Integer> postIndex = new BoxValue<>(inOrder.length - 1);
        return getTreeFromInAndPost(inOrder, postOrder, postIndex, 0, inOrder.length - 1);
    }


    private Node<T> getTreeFromInAndPost(T[] inOrder, T[] postOrder, BoxValue<Integer> postIndex, int start, int end) {
        if (start > end || postIndex.value < 0) {
            return null;
        }
        Node<T> node = new Node<T>(postOrder[postIndex.value]);
        postIndex.value--;

        //   System.out.println(node.data);

        int inOrderIndex = findIndex(inOrder, start, end, (Integer) node.data);

        node.right = getTreeFromInAndPost(inOrder, postOrder, postIndex, inOrderIndex + 1, end);
        node.left = getTreeFromInAndPost(inOrder, postOrder, postIndex, start, inOrderIndex - 1);


        return node;

    }
}