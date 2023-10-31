package org.example;

public class Ex9_5 {
    static class TreeNode{
        double item;
        TreeNode left;
        TreeNode right;
        TreeNode (double real){
            item =real;
        }

    }
    static class TreeQueue{
        private static class Node{
            TreeNode item;
            TreeQueue.Node next;
        }
        private TreeQueue.Node head = null;
        private TreeQueue.Node tail = null;

        void enqueue(TreeNode tree){
            TreeQueue.Node newTail = new TreeQueue.Node();
            newTail.item = tree;
            if(head==null){
                head = newTail;
                tail = newTail;
            } else {
                tail.next = newTail;
                tail = newTail;
            }
        }
        TreeNode dequeue(){
            if(head ==null)
                throw new IllegalStateException("Can't dequeue from an empty queue. ");
            TreeNode firstItem = head.item;
            head = head.next;
            if(head==null){
                tail = null;
            }
            return firstItem;
        }
        boolean isEmpty(){
            return (head==null);
        }
    }
    static TreeNode root;

    private static void treeInsert(double num){
        if(root == null){
            root = new TreeNode(num);
            return;
        }
        TreeNode runner;
        runner = root;
        while (true) {
            if(num< root.item){
                if(runner.left==null){
                    runner.left=new TreeNode(num);
                    return;
                } else {
                    runner = runner.left;
                }
            } else {
                if(runner.right==null){
                    runner.right=new TreeNode(num);
                    return;
                } else
                    runner = runner.right;
            }
        }
    }
    private static void levelOrderPrint(TreeNode root) {
        if(root==null)
            return;
        TreeQueue queue = new TreeQueue();
        queue.enqueue(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.dequeue();
            System.out.println(node.item);
            if(node.left!=null){
                queue.enqueue(node.left);
            }
            if(node.right!=null){
                queue.enqueue(node.right);
            }
        }
    }
    static int countDepth(TreeNode node){
        if(node==null)
            return 0;
        else if(node.left==null && node.right==null)
            return 1;
        else
            return countDepth(node.left)+countDepth(node.right);
    }
    static int sumOfDepth(TreeNode node, int depth){
        if(node==null){
            return 0;
        } else if(node.left==null && node.right==null){
            return depth;
        } else {
            return sumOfDepth(node.left,depth+1)+sumOfDepth(node.right,depth+1);
        }
    }
    static int maxDepth(TreeNode node, int depth){
        if(node==null){
            return  0;
        } else {
            int leftMax= maxDepth(node.left,depth+1);
            int rightMax= maxDepth(node.right,depth+1);
            if(leftMax>rightMax)
                return leftMax;
            else
                return rightMax;
        }
    }

    public static void main(String[] args) {
        for(int i= 0 ; i<1024;i++){
            treeInsert(Math.random());
        }
        int count = countDepth(root);
        int sumOfDepth = sumOfDepth(root,0);
        int maxDepth = maxDepth(root,0);
        double avgDepth = (double) sumOfDepth /count;
        System.out.println("count the depth : " + count);
        System.out.println("Sum of Depth : " + sumOfDepth);
        System.out.println("Max depth :" + maxDepth);
    }
}
