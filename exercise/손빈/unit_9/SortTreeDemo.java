package org.example;

import java.util.Scanner;

public class SortTreeDemo {
    private static class TreeNode {
        String item;
        TreeNode left;
        TreeNode right;
        TreeNode(String str) {
            item = str;
        }
    }

    private static TreeNode root;

    public static void main(String[] args) {
        
        Scanner in = new Scanner( System.in );

        System.out.println("This program stores strings that you enter in a binary sort");
        System.out.println("tree.  After each item is inserted, the contents of the tree");
        System.out.println("are displayed.  The number of nodes in the tree is also output.");
        System.out.println("    Any string you enter will be converted to lower case.");
        System.out.println("Duplicate entries are ignored.");

        while (true) {
            System.out.println("\n\nEnter a string to be inserted, or press return to end.");
            System.out.print("?  ");
            String item;
            item = in.nextLine().trim().toLowerCase(); 
            if (item.length() == 0)
                break;
            if (treeContains(root,item)) {
                System.out.println("\nThat item is already in the tree.");
            }
            else {
                treeInsert(item);
                System.out.println("\nThe tree contains " + countNodes(root) + " items.");
                System.out.println("\nContents of tree:\n");
                treeList(root);
            }
        }

        System.out.println("\n\nExiting program.");

    }

    private static void treeInsert(String newItem) {
        if ( root == null ) {
            root = new TreeNode( newItem );
            return;
        }
        TreeNode runner;
        runner = root;
        while (true) {
            if ( newItem.compareTo(runner.item) < 0 ) {
                if ( runner.left == null ) {
                    runner.left = new TreeNode( newItem );
                    return;
                }
                else
                    runner = runner.left;
            }
            else {
                if ( runner.right == null ) {
                    runner.right = new TreeNode( newItem );
                    return;
                }
                else
                    runner = runner.right;
            }
        }
    }
    static boolean treeContains( TreeNode root, String item ) {
        if ( root == null ) {
            return false;
        }
        else if ( item.equals(root.item) ) {
            return true;
        }
        else if ( item.compareTo(root.item) < 0 ) {
            return treeContains( root.left, item );
        }
        else {
            return treeContains( root.right, item );
        }
    }
    private static void treeList(TreeNode node) {
        if ( node != null ) {
            treeList(node.left);
            System.out.println("  " + node.item);
            treeList(node.right);
        }
    }

    private static int countNodes(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int leftCount = countNodes(node.left);
            int rightCount = countNodes(node.right);
            return 1 + leftCount + rightCount;
        }
    }

}