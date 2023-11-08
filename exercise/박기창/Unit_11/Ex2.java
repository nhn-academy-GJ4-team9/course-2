package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

public class Ex2 {

    public static void main(String[] args) {


        for (int i = 0; i < args.length; i++) {
            countLine(args[i]);
        }

    }

    private static void countLine(String arg) {


        try(BufferedReader br = new BufferedReader(new FileReader(arg))) {

            String s= br.readLine();
            int count=0;
            while(s != null){
                s=br.readLine();
                count++;
            }

            System.out.println(count);

        } catch (FileNotFoundException e) {
            System.out.println("파일을 못찾음");
        } catch (IOException e) {
            System.out.println("오류 발생");
        }
    }

}
