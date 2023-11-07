package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ex11_2 {
    public static void main(String[] args) {
       if(args.length==0){
           System.out.println("need file name args");
           return;
       }
       for(int i = 0 ; i<args.length;i++){
           System.out.println(args[i] + ": " );
           countLine(args[i]);
       }
    }

    public static void countLine(String fileName) {
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            int count = 0;
            String line;
            while ( (line = br.readLine())!=null){
                count++;

            }
            System.out.println(count);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
