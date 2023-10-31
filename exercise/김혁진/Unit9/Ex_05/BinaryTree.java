package Ex_05;

public class BinaryTree {

    static class TreeNode {
        double value;
        TreeNode left;
        TreeNode right;

        TreeNode(double value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    private static TreeNode root;

    public BinaryTree() {
        root = null;
    }

    public void insert(double value) {
        root = insertRecursive(root, value);
    }

    private TreeNode insertRecursive(TreeNode root, double value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }
        if (value < root.value) {
            root.left = insertRecursive(root.left, value);
        } else if (value > root.value) {
            root.right = insertRecursive(root.right, value);
        }
        return root;
    }

    private static int depthSearch(TreeNode node, int depth){
        if(node == null){
            return 0;
        } else if (node.left == null && node.right == null) {
            return depth;
        } else {
            int leftMax = depthSearch(node.left, depth + 1);
            int rightMax = depthSearch(node.right, depth + 1);
            if (leftMax > rightMax)
                return leftMax;
            else
                return rightMax;
        }
    }

    static int countLeaves(TreeNode node) {
        if (node == null)
            return 0;
        else if (node.left == null && node.right == null)
            return 1;
        else
            return countLeaves(node.left) + countLeaves(node.right);
    }

    static int sumOfLeafDepths(TreeNode node, int depth) {
        if (node == null) {
            return 0;
        } else if (node.left == null && node.right == null) {
            return depth;
        } else {
            return sumOfLeafDepths(node.left, depth + 1)
                    + sumOfLeafDepths(node.right, depth + 1);
        }
    }


    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        root = null;

        for (int i = 0; i < 1023; i++) {
            tree.insert(Math.random());
        }
        int leafCount = countLeaves(root);
        int depthSum = sumOfLeafDepths(root, 0);
        int depthMax = depthSearch(root, 0);
        double averageDepth = ((double) depthSum) / leafCount;

        System.out.println("마지막노드 개수 : " + leafCount);
        System.out.println("평균깊이  " + averageDepth);
        System.out.println("최고깊이 : " + depthMax);
    }
}
