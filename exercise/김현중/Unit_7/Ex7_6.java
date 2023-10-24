package com.example.chapter7;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Ex7_6 {
    public static void main(String[] args) {
        InputStream file = Ex7_6.class.getClassLoader().getResourceAsStream("test.txt");
        ArrayList<String> arrayList;
        arrayList = readFile(file);
        arrayList = distinctList(arrayList);
        arrayList = sortList(arrayList);
        writeFile(arrayList);

    }

    public static ArrayList<String> readFile(InputStream file) {
        String line;
        ArrayList<String> arrayList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(file))) {
            while ((line = br.readLine()) != null) {
                arrayList.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }

    public static ArrayList<String> distinctList(ArrayList<String> strings) {


        return (ArrayList<String>) strings.stream().distinct().map(String::toLowerCase).collect(Collectors.toList());
    }

    public static ArrayList<String> sortList(ArrayList<String> strings) {
        for(String str : strings){
            str.toLowerCase();
        }
        Collections.sort(strings);

        return strings;
    }

    public static void writeFile(ArrayList<String> strings) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("sorte.txt"))) {
            for (String str : strings) {
                pw.println(str);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
