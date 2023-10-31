package org.example;

public class Ex9_4 {
    static class StrTreeNode {
        String item;
        StrTreeNode left;
        StrTreeNode right;
        StrTreeNode(String str) {
            item = str;
        }
    }

    static class TreeQueue {
        private static class Node {
            StrTreeNode item;
            Node next;
        }

        private Node head = null;
        private Node tail = null;

        void enqueue(StrTreeNode tree) {
            Node newTail = new Node();
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
            if (head == null)
                throw new IllegalStateException("Can't dequeue from an empty queue.");
            StrTreeNode firstItem = head.item;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return firstItem;
        }

        boolean isEmpty() {
            return (head == null);
        }
    }

    static StrTreeNode root;

    static void levelOrderPrint(StrTreeNode root) {
        if (root == null)
            return;
        TreeQueue queue;
        queue = new TreeQueue();
        queue.enqueue(root);
        while (queue.isEmpty() == false) {
            StrTreeNode node = queue.dequeue();
            System.out.println(node.item);
            if (node.left != null)
                queue.enqueue(node.left);
            if (node.right != null)
                queue.enqueue(node.right);
        }
    }

    static void treeInsert(String newItem) {
        if (root == null) {
            root = new StrTreeNode(newItem);
            return;
        }
        StrTreeNode runner;
        runner = root;
        while (true) {
            if (newItem.compareTo(runner.item) < 0) {
                if (runner.left == null) {
                    runner.left = new StrTreeNode(newItem);
                    return;
                } else
                    runner = runner.left;
            } else {
                if (runner.right == null) {
                    runner.right = new StrTreeNode(newItem);
                    return;
                } else
                    runner = runner.right;
            }
        }
    }

    public static void main(String[] args) {
        treeInsert("judy");
        treeInsert("bill");
        treeInsert("fred");
        treeInsert("mary");
        treeInsert("dave");
        treeInsert("jane");
        treeInsert("alice");
        treeInsert("joe");
        treeInsert("tom");
        levelOrderPrint(root);
    }
}
