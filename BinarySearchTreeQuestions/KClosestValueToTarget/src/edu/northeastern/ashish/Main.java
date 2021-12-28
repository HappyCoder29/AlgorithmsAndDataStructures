package edu.northeastern.ashish;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        BST tree = new BST();
        tree.root = createBST();
        ArrayList<Integer> list = tree.getKClosestValues(2, 3.714286f);
        System.out.println(Arrays.toString(list.toArray()));
    }

    private static Node createBST(){
        Node root = new Node(4);

        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        return root;

    }
}
