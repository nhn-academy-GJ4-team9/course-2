package org.example;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class Ex11_1 {
    public static void main(String[] args) {
        String directoryName;
        File directory;
        System.out.print("Enter a directory name: ");
        try (Scanner sc = new Scanner(System.in)) {
            directoryName = sc.nextLine().trim();
            directory = new File(directoryName);
            if (directory.isDirectory() == false) {
                if (directory.exists() == false) {
                    System.out.println("There is no such directory!");
                } else
                    System.out.println("That file is not a directory.");
            } else {
                try(Stream<Path> stream = Files.walk(Paths.get(directoryName))) {
                    stream.filter(Files::isRegularFile).forEach(System.out::println);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
//            listDirectoryContents(directory,"");
            }


        }
    }
//    private static void listDirectoryContents(File dir, String indent) {
//        String[] files;  // List of names of files in the directory.
//        System.out.println(indent + "Directory \"" + dir.getName() + "\":");
//        indent += "   ";  // Increase the indentation for listing the contents.
//        files = dir.list();
//        for (int i = 0; i < files.length; i++) {
//            // If the file is a  directory, list its contents
//            // recursively.  Otherwise, just print its name.
//            File f = new File(dir, files[i]);
//            if (f.isDirectory())
//                listDirectoryContents(f, indent);
//            else
//                System.out.println(indent + files[i]);
//        }
//    }

}

