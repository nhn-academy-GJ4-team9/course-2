package com.example.chapter7;

import java.util.ArrayList;

public class Ex7_1 {
    public static void main(String[] args) {
        System.out.println(createList(100, 10));
    }

    public static ArrayList<Integer> createList(int max, int numb) {

        ArrayList<Integer> arrayList = new ArrayList<>(numb);
        for (int i = 0; i < numb; i++)
            arrayList.add((int) (Math.random()*max + 1));
        return arrayList;
    }
}
