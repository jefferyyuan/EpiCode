package com.epi;

import static com.epi.BinaryTreeWithParentPrototype.BinaryTree;

/**
 * @author translated from c++ by Blazheev Alexander
 */
public class Successor {
    // @include
    public static <T> BinaryTree<T> find_successor(BinaryTree<T> node) {
        BinaryTree<T> n = node;
        if(n.getRight() != null) {
            // Find the leftmost element in n's right subtree.
            n = n.getRight();
            while(n.getLeft() != null) {
                n = n.getLeft();
            }
            return n;
        }

        // Find the first parent whose left child contains n.
        while(n.getParent() != null && n.getParent().getRight() == n) {
            n = n.getParent();
        }
        // Return nullptr means n does not have successor.
        return n.getParent();
    }
    // @exclude

    public static void main(String[] args) {
        //      3
        //    2   5
        //  1    4  6
        BinaryTree<Integer> root = new BinaryTree<Integer>(3, null, null);
        root.setLeft(new BinaryTree<Integer>(2, null, null));
        root.getLeft().setParent(root);
        root.getLeft().setLeft(new BinaryTree<Integer>(1, null, null));
        root.getLeft().getLeft().setParent(root.getLeft());
        root.setRight(new BinaryTree<Integer>(5, null, null));
        root.getRight().setParent(root);
        root.getRight().setLeft(new BinaryTree<Integer>(4, null, null));
        root.getRight().getLeft().setParent(root.getRight());
        root.getRight().setRight(new BinaryTree<Integer>(6, null, null));
        root.getRight().getRight().setParent(root.getRight());
        // should output 6
        BinaryTree<Integer> node = find_successor(root.getRight());
        assert(node.getData().equals(6));
        if(node != null) {
            System.out.println(node.getData());
        } else {
            System.out.println("null");
        }
        // should output "null"
        node = find_successor(root.getRight().getRight());
        assert(node == null);
        if(node != null) {
            System.out.println(node.getData());
        } else {
            System.out.println("null");
        }
    }
}
