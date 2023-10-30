package org.example;

import java.io.FileNotFoundException;

public class Ex9_2 {

    private static TreeNode root;

    public static void main(String[] args) {
        try {
           String word = readNextWord(inputFile);
            while (word != null) {
                word = word.toLowerCase();
                if (!treeContains(root, word)) {
                    root = treeInsert(root, word);
                }
                word = readNextWord(inputFile);
            }

        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다.");
        } catch (Exception e) {
            System.out.println("죄송합니다, 오류가 발생했습니다.");
            System.out.println("오류 메시지: " + e.getMessage());
        }
    }

    private static TreeNode treeInsert(TreeNode node, String word) {
        if (node == null) {
            return new TreeNode(word);
        }

        int comparison = word.compareTo(node.data);
        if (comparison < 0) {
            node.left = treeInsert(node.left, word);
        } else if (comparison > 0) {
            node.right = treeInsert(node.right, word);
        }

        return node;
    }

    private static boolean treeContains(TreeNode node, String word) {
        if (node == null) {
            return false;
        }

        int comparison = word.compareTo(node.data);
        if (comparison < 0) {
            return treeContains(node.left, word);
        } else if (comparison > 0) {
            return treeContains(node.right, word);
        }

        return true;
    }

    private static class TreeNode {
        String data;
        TreeNode left;
        TreeNode right;

        public TreeNode(String data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
