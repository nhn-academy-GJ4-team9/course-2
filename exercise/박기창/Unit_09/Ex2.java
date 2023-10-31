package org.example;

import static org.example.SortTreeDemo.*;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Ex2 {

    static TreeNode root = null;

    public static void main(String[] args) {


        try (InputStream is = Ex2.class.getClassLoader().getResourceAsStream("file.txt");
             Reader rd = new InputStreamReader(is, "UTF-8");
             BufferedReader br = new BufferedReader(rd)) {

            String s="";
            while(true){
                s = br.readLine();

                if (s == null) {
                    break;
                }
                treeInsert(s);

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        treeList(root);

    }

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
    }  //
}
