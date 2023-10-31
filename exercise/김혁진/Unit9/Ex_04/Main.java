package Ex_04;

public class Main {
    /**
     * 큐가 비어 있지 않은 동안
     * 빈 큐에 루트 노드를 추가합니다 .
     *    큐에서 노드를 가져옵니다.
     *    node.left가 null이 아니면
     *    노드의 항목을 인쇄합니다 .
     *    node.right가 null이 아니면
     *       큐에 추가합니다 .
     *       추가합니다. 대기열에
     */

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

    static class TreeNode {
        String item;
        TreeNode left;
        TreeNode right;

        TreeNode(String str) {
            this.item = str;
        }
    }

    static class TreeQueue {
        static class Node {
            TreeNode item;
            Node next;

            Node(TreeNode tree) {
                this.item = tree;
            }
        }

        private Node head = null;
        private Node tail = null;

        void enqueue(TreeNode tree) {
            Node newTail = new Node(tree);
            if (head == null) {
                head = newTail;
                tail = newTail;
            } else {
                tail.next = newTail;
                tail = newTail;
            }
        }

        TreeNode dequeue() {
            if (head == null) {
                throw new IllegalStateException("큐가 비어있음");
            }
            TreeNode firstItem = head.item;
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

    static TreeNode root;

    static void levelOrderPrint(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeQueue queue = new TreeQueue();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.dequeue();
            System.out.println(node.item);
            if (node.left != null) {
                queue.enqueue(node.left);
            }
            if (node.right != null) {
                queue.enqueue(node.right);
            }
        }
    }

    static void treeInsert(String newItem) {
        if (root == null) {
            root = new TreeNode(newItem);
            return;
        }
        TreeNode nowNode = root;
        while (true) {
            if (newItem.compareTo(nowNode.item) < 0) {
                if (nowNode.left == null) {
                    nowNode.left = new TreeNode(newItem);
                    return;
                } else
                    nowNode = nowNode.left;
            } else {
                if (nowNode.right == null) {
                    nowNode.right = new TreeNode(newItem);
                    return;
                } else
                    nowNode = nowNode.right;
            }
        }
    }
}
