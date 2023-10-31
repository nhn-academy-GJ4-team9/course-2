package org.example;

public class Ex5 {
    static TreeNode root;   // Pointer to the binary sort tree.

    static class TreeNode {
        double item;      // The data in this node.
        TreeNode left;    // Pointer to left subtree.
        TreeNode right;   // Pointer to right subtree.

        TreeNode(double x) {
            // Constructor.  Make a node containing x.
            item = x;
        }
    } // end class TreeNode

    static void treeInsert(double x) {
        if (root == null) {
            // The tree is empty.  Set root to point to a new node
            // containing the new item.
            root = new TreeNode(x);
            return;
        }
        TreeNode runner; // Runs down the tree to find a place for newItem.
        runner = root;   // Start at the root.
        while (true) {
            if (x < runner.item) {
                if (runner.left == null) {
                    runner.left = new TreeNode(x);
                    return;  // New item has been added to the tree.
                } else {
                    runner = runner.left;
                }
            } else {
                if (runner.right == null) {
                    runner.right = new TreeNode(x);
                    return;  // New item has been added to the tree.
                } else {
                    runner = runner.right;
                }
            }
        } // end while
    }  // end treeInsert()

    static int countLeaves(TreeNode node) {
        if (node == null) {
            return 0;
        } else if (node.left == null && node.right == null) {
            return 1;
        } else {
            return countLeaves(node.left) + countLeaves(node.right);
        }
    } // end countNodes()


    static int sumOfLeafDepths(TreeNode node, int depth) {
        if (node == null) {
            return 0;
        } else if (node.left == null && node.right == null) {
            return depth;
        } else {
            return sumOfLeafDepths(node.left, depth + 1)
                    + sumOfLeafDepths(node.right, depth + 1);
        }
    } // end sumOfLeafDepths()

    static int maximumLeafDepth(TreeNode node, int depth) {
        if (node == null) {
            // The tree is empty.  Return 0.
            return 0;
        } else if (node.left == null && node.right == null) {
            return depth;
        } else {
            int leftMax = maximumLeafDepth(node.left, depth + 1);
            int rightMax = maximumLeafDepth(node.right, depth + 1);
            if (leftMax > rightMax) {
                return leftMax;
            } else {
                return rightMax;
            }
        }
    } // end maximumLeafDepth()

    public static void main(String[] args) {

        root = null;
        for (int i = 0; i < 1023; i++) {
            treeInsert(Math.random());
        }


        int leafCount = countLeaves(root);
        int depthSum = sumOfLeafDepths(root, 0);
        int depthMax = maximumLeafDepth(root, 0);
        double averageDepth = ((double) depthSum) / leafCount;

        // Display the results.

        System.out.println("Number of leaves:         " + leafCount);
        System.out.println("Average depth of leaves:  " + averageDepth);
        System.out.println("Maximum depth of leaves:  " + depthMax);

    }  // end main()
}
