package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Ex5 {
    public static void main(String[] args) throws IOException {

        try (InputStream is = Ex5.class.getClassLoader().getResourceAsStream("sales.dat");
             Reader rd = new InputStreamReader(is, "UTF-8");
             BufferedReader br = new BufferedReader(rd)) {


            String s = "";
            String[] sarr;

            int noinfo = 0;

            double sum = 0.0;


            while (true) {

                s = br.readLine();

                if (s == null) {
                    break;
                }

                sarr = s.split(":");


                try {
                    sum += Double.parseDouble(sarr[1]);
                } catch (NumberFormatException e) {
                    noinfo++;
                }

            }


            System.out.println(noinfo);
            System.out.println(sum);

        } catch (IOException e) {
            e.getMessage();
        }


    }
}
