package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ex6 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        try (InputStream is = Ex6.class.getClassLoader().getResourceAsStream("file.txt");
             Reader rd = new InputStreamReader(is, "UTF-8");
             BufferedReader br = new BufferedReader(rd)) {

            String s="";
            while(true){
                s = br.readLine();

                if (s == null) {
                    break;
                }
                list.add(s);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }



        list.sort(Comparator.naturalOrder());

        String filePath = Ex6.class.getClassLoader().getResource("file.txt").getPath();


        System.out.println(filePath);

        try (OutputStream os = new FileOutputStream(filePath);
             Writer wr = new OutputStreamWriter(os, "UTF-8");
             BufferedWriter bw = new BufferedWriter(wr)) {
            for (String s : list) {
                bw.write(s);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }



    }
}
