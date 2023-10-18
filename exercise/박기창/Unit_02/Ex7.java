package org.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Ex7 {
    public static void main(String[] args) {


        try (InputStream is = new FileInputStream(
                "/Users/park/Desktop/선택과정2/unit1_2/src/main/java/org/example/testdata.txt")) {
            Reader rd = new InputStreamReader(is, "UTF-8");
            BufferedReader br = new BufferedReader(rd);
            System.out.println(br.readLine());
            int count = 0;
            int sum = 0;
            while (true) {

                String str = br.readLine();
                if (str == null) {
                    break;
                }
                sum += Integer.parseInt(str);
                count++;
            }
            double avg = (double) sum / count;
            System.out.println(avg);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
