package org.example;

import java.util.Scanner;


public class SortTreeDemo {


    public static class TreeNode {
        String item;      // The data in this node.
        TreeNode left;    // Pointer to left subtree.
        TreeNode right;   // Pointer to right subtree.
        TreeNode(String str) {

            item = str;
        }
    }  // end nested class TreeNode


    private static TreeNode root;

    public static void main(String[] args) {

        Scanner in = new Scanner( System.in );  // for reading user's input

        while (true) {
            System.out.println("\n\nEnter a string to be inserted, or press return to end.");
            System.out.print("?  ");
            String item;  // The user's input.
            item = in.nextLine().trim().toLowerCase();
            if (item.length() == 0)
                break;
            if (treeContains(root,item)) {
                System.out.println("\nThat item is already in the tree.");
            }
            else {
                treeInsert(item);  // Add user's string to the tree.
                System.out.println("\nThe tree contains " + countNodes(root) + " items.");
                System.out.println("\nContents of tree:\n");
                treeList(root);
            }
        }  // end while

        System.out.println("\n\nExiting program.");

    }  // end main()

    public static void treeInsert(String newItem) {
        if ( root == null ) {
            // The tree is empty.  Set root to point to a new node containing
            // the new item.  This becomes the only node in the tree.
            root = new TreeNode( newItem );
            return;
        }
        TreeNode runner;  // Runs down the tree to find a place for newItem.
        runner = root;   // Start at the root.
        while (true) {
            if ( newItem.compareTo(runner.item) < 0 ) {
                if ( runner.left == null ) {
                    runner.left = new TreeNode( newItem );
                    return;  // New item has been added to the tree.
                }
                else
                    runner = runner.left;
            }
            else {
                if ( runner.right == null ) {
                    runner.right = new TreeNode( newItem );
                    return;  // New item has been added to the tree.
                }
                else
                    runner = runner.right;
            }
        } // end while
    }  // end treeInsert()


    static boolean treeContains( TreeNode root, String item ) {
        if ( root == null ) {
            // Tree is empty, so it certainly doesn't contain item.
            return false;
        }
        else if ( item.equals(root.item) ) {
            // Yes, the item has been found in the root node.
            return true;
        }
        else if ( item.compareTo(root.item) < 0 ) {
            // If the item occurs, it must be in the left subtree.
            return treeContains( root.left, item );
        }
        else {
            // If the item occurs, it must be in the right subtree.
            return treeContains( root.right, item );
        }
    }  // end treeContains()


    public static void treeList(TreeNode node) {
        if ( node != null ) {
            treeList(node.left);             // Print items in left subtree.
            System.out.println("  " + node.item);  // Print item in the node.
            treeList(node.right);            // Print items in the right subtree.
        }
    } // end treeList()


    public static int countNodes(TreeNode node) {
        if ( node == null ) {
            // Tree is empty, so it contains no nodes.
            return 0;
        }
        else {
            // Add up the root node and the nodes in its two subtrees.
            int leftCount = countNodes( node.left );
            int rightCount = countNodes( node.right );
            return  1 + leftCount + rightCount;
        }
    } // end countNodes()


} // end class SortTreeDemo