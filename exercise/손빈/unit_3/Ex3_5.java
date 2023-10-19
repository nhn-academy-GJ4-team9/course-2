package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex3_5 {
    public static void main(String[] args) {
        String fileName = "sales.dat";
        int citiesData = 0;
        double total = 0.0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(" ");
                if (parts.length == 2) {
                    String cityName = parts[0].trim();
                    String data = parts[1].trim();

                    if (!data.equals("")) {
                        try {
                            double sales = Double.parseDouble(data);
                            total += sales;
                        } catch (NumberFormatException e) {
                            System.err.println(cityName);
                        }
                    } else {
                        citiesData++;
                    }
                }
            }
        } catch (IOException e) {

        }
        System.out.println(total);
        System.out.println(citiesData);
    }
}

