package com.example.chapter7;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import org.w3c.dom.ls.LSOutput;

public class Ex7_5 {
    public static void main(String[] args) {
        ArrayList<Double> doubles = new ArrayList<>();
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("enter real number, enter 0 to end");
            double tmp;
            while (true){

                tmp = sc.nextDouble();
                if(tmp <0)
                    throw new IllegalArgumentException("not negative");
                doubles.add(tmp);
                if(tmp == 0)
                    break;
            }
            System.out.println("sorted doubles");
            System.out.println();
            printArray(doubles);
        }

    }

    public static ArrayList<Double> sortDouble(ArrayList<Double> doubleArray) {
        for(int i = 0 ; i< doubleArray.size()-1 ; i++){
            if(doubleArray.get(i)>doubleArray.get(i+1)){
                double tmp = doubleArray.get(i);
                doubleArray.set(i,doubleArray.get(i+1));
                doubleArray.set(i+1,tmp);
                i= -1;
            }
        }
        return doubleArray;
    }
    public static void printArray(ArrayList<Double> doubleArray){
        System.out.println(sortDouble(doubleArray));
    }



}
