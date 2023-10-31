package org.example;

import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeMap;

public class Ex1 {
    public static void main(String[] args) {
            PhoneDirectoryWithTreeMap directory = new PhoneDirectoryWithTreeMap();
            directory.putNumber("Fred","555-1234");
            directory.putNumber("Barney","555-2345");
            directory.putNumber("Wilma","555-3456");
            System.out.println("Contents are:");
            System.out.println();
            directory.print();
            System.out.println();
            System.out.println("Number for Fred is " + directory.getNumber("Fred"));
            System.out.println("Number for Wilma is " + directory.getNumber("Wilma"));
            System.out.println("Number for Tom is " + directory.getNumber("Tom"));


    }
}

class PhoneDirectoryWithTreeMap {
    static TreeMap<String,String> treeMap;

    public PhoneDirectoryWithTreeMap() {
        treeMap = new TreeMap<>();
    }


    public void putNumber(String fred, String s) {
        if ("".equals(fred) || "".equals(s)){
            throw new IllegalArgumentException();
        }
        treeMap.put(fred,s);
    }


    public void print() {
        Iterator it = treeMap.entrySet().iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }

    public String getNumber(String fred) {
       return treeMap.get(fred);
    }
}
