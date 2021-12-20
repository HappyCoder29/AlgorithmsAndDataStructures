package edu.northeastern.ashish;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.root = createTree();

        ArrayList<ArrayList<Integer>> listOfPaths = tree.getAllRootToLeaf();
        for (ArrayList<Integer> path : listOfPaths) {
            System.out.println(Arrays.toString(path.stream().mapToInt(i -> i).toArray()));
        }

        ///tree.printAllRootToLeaf();
       // ArrayList<ArrayList<Integer>> allList = tree.allPathSum(22);
        System.out.println();

    }

    private static Node<Integer> createTree(){
        Node<Integer> root = new Node<>(1);

        // Second level
        root.left = new Node<>(2);
        root.right = new Node<>(3);

        // Third Level
        root.left.left = new Node<>(4);
        root.left.right = new Node<>(5);
        root.right.left = new Node<>(6);
        root.right.right = new Node<>(7);

        // Fourth Level
        root.left.left.left = new Node<>(8);
        root.left.right.left = new Node<>(9);
        root.right.left.left = new Node<>(10);
        root.right.right.right = new Node<>(11);

        return root;
    }
}
