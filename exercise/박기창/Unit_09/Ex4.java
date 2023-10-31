package org.example;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Ex4 {
    static class StrTreeNode {
        String item;  // The item
        StrTreeNode left;  // Pointer to left subtree.
        StrTreeNode right; // Pointer to right subtree.
        StrTreeNode(String str) {
            // Constructor.  Make a node to contain str.
            item = str;
        }
    }
    static class TreeQueue {
        private static class Node {
            StrTreeNode item;
            Node next;
        }
        private Node head = null;  // Points to first Node in the queue.
        private Node tail = null;  // Points to last Node in the queue.
        void enqueue(StrTreeNode tree) {
            Node newTail = new Node();  // A Node to hold the new item.
            newTail.item = tree;
            if (head == null) {
                head = newTail;
                tail = newTail;
            } else {
                tail.next = newTail;
                tail = newTail;
            }
        }

        StrTreeNode dequeue() {
            if (head == null) {
                throw new IllegalStateException("Can't dequeue from an empty queue.");
            }
            StrTreeNode firstItem = head.item;
            head = head.next;  // The previous second item is now first.
            if (head == null) {
                tail = null;
            }
            return firstItem;
        }
        boolean isEmpty() {
            return (head == null);
        }

    }



    static StrTreeNode root;  // A pointer to the root of the binary tree.


    static void treeInsert(String newItem) {
        if (root == null) {
            root = new StrTreeNode(newItem);
            return;
        }
        StrTreeNode runner; // Runs down the tree to find a place for newItem.
        runner = root;   // Start at the root.
        while (true) {
            if (newItem.compareTo(runner.item) < 0) {

                if (runner.left == null) {
                    runner.left = new StrTreeNode(newItem);
                    return;  // New item has been added to the tree.
                } else {
                    runner = runner.left;
                }
            } else {
                if (runner.right == null) {
                    runner.right = new StrTreeNode(newItem);
                    return;  // New item has been added to the tree.
                } else {
                    runner = runner.right;
                }
            }
        } // end while
    }  // end treeInsert()

    static void levelOrderPrint(StrTreeNode root) {
        if (root == null) {
            return;  // There is nothing to print in an empty tree.
        }
        TreeQueue queue;   // The queue, which will only hold non-null nodes.
        queue = new TreeQueue();
        queue.enqueue(root);
        while (queue.isEmpty() == false) {
            StrTreeNode node = queue.dequeue();
            System.out.println(node.item);
            if (node.left != null) {
                queue.enqueue(node.left);
            }
            if (node.right != null) {
                queue.enqueue(node.right);
            }
        }
    } // end levelOrderPrint()

    public static void main(String[] args) {
        treeInsert("1");
        treeInsert("2");
        treeInsert("9");
        treeInsert("4");
        treeInsert("5");
        treeInsert("6");
        treeInsert("7");
        treeInsert("8");
        treeInsert("3");
        levelOrderPrint(root);

    } // end main()


} // end class TreePrintNonRecursive