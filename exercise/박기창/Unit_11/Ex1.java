package org.example;

import java.io.File;
import java.util.Scanner;

public class Ex1 {


    public static void main(String[] args) {
        String directoryName;  // Directory name entered by the user.
        File directory;        // File object referring to the directory.
        String[] files;        // Array of file names in the directory.
        // For reading a line of input from the user.

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a directory name: ");
            directoryName = scanner.nextLine().trim();
            directory = new File(directoryName);

            if (directory.isDirectory() == false) {
                if (directory.exists() == false) {
                    System.out.println("There is no such directory!");
                } else {
                    System.out.println("That file is not a directory.");
                }
            } else {
                recursive(directory, "");

            }
        }


    }

    private static void recursive(File directory, String s) {
        String[] files;
        files = directory.list();
        System.out.println(s + "Files in directory \"" + directory + "\":");

        s += " ";
        for (int i = 0; i < files.length; i++) {
            File file = new File(directory, files[i]);

            if (file.isDirectory()) {
                recursive(file, s);
            } else {
                System.out.println(s + files[i]);
            }

        }
    }
}
