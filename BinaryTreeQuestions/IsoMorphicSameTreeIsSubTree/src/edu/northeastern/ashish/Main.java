package edu.northeastern.ashish;

public class Main {

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.root = createTree();

        Node<Integer> node1 = generateSameNodes1();
        Node<Integer> node2 = generateSameNodes2();

        System.out.println("Nodes 1 and 2 are isoMorphic ? : " + areIsomorphic(node1, node2));
        System.out.println("Nodes 1 and 2 are same nodes ? : " + areSameNodes(node1, node2));
        System.out.println("Is Subtree ? : " + isSubTree(tree.root, generateSubTree()));


    }


    public static boolean areIsomorphic(Node<Integer>node1, Node<Integer> node2){
        if(node1 == null && node2 == null){
            return true;
        }
        if(node1 == null || node2 == null){
            return false;
        }
        return  areIsomorphic(node1.left, node2.left) && areIsomorphic(node1.right, node2.right);
    }


    public static boolean areSameNodes(Node<Integer>node1, Node<Integer> node2){
        if(node1 == null && node2 == null){
            return true;
        }
        if(node1 == null || node2 == null){
            return false;
        }
        return  (node1.data == node2.data) &&
                areSameNodes(node1.left, node2.left) &&
                areSameNodes(node1.right, node2.right);
    }

    public static boolean isSubTree(Node<Integer> tree, Node<Integer> subTree){
        return  areSameNodes(tree, subTree) ||
                areSameNodes(tree.left, subTree) ||
                areSameNodes(tree.right, subTree);
    }


    public static Node<Integer> createTree(){
        Node<Integer> root = new Node<>(1);

        // First Level
        root.left = new Node<>(2);
        root.right = new Node<>(3);

        // Second level
        root.left.left = new Node<>(4);
        root.left.right = new Node<>(5);
        root.right.left = new Node<>(6);
        root.right.right = new Node<>(7);

        // Third Level
        root.left.left.left = new Node<>(8);
        //root.left.right.left = new Node<>(9);
        root.right.left.right = new Node<>(10);
        root.right.right.right = new Node<>(11);

        return root;
    }

    private static Node<Integer> generateSameNodes1(){
        Node<Integer> node = new Node<>(1);
        node.left = new Node<>(2);
        node.right = new Node<>(3);
        node.left.left = new Node<>(4);
        node.left.right = new Node<>(5);

        return node;
    }

    private static Node<Integer> generateSameNodes2(){
        Node<Integer> node = new Node<>(1);
        node.left = new Node<>(5);
        node.right = new Node<>(7);
        node.left.left = new Node<>(3);
        node.left.right = new Node<>(6);

        return node;
    }

    private static Node<Integer> generateSubTree(){
        Node root = new Node<>(3);

        root.left = new Node<>(6);
        root.right = new Node<>(7);

        root.left.right = new Node<>(10);
        root.right.right = new Node<>(11);

        return root;

    }
}
