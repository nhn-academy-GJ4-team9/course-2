package org.example;

import java.io.*;
import java.text.NumberFormat;
import java.util.Arrays;

public class Ex3_5 {
    public static void main(String[] args) {
        InputStream file = Ex3_5.class.getClassLoader().getResourceAsStream("sales.dat");
        String line = null;
        double total = 0;


        try (BufferedReader br = new BufferedReader(new InputStreamReader(file))) {
            while ((line =br.readLine()) != null){
                String sales[] = line.split(":");
                System.out.println(Arrays.toString(sales));
                try {
                  total += Double.parseDouble(sales[1]);
                } catch (NumberFormatException e){
                    System.out.println("we did not received or it's not a number");
                }

            }
            System.out.println("total sale is" + total);

        }  catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
