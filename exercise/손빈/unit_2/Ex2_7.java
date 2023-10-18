package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex2_7 {
    public static void main(String[] args) {
        String fileName = "testdata.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String studentName = reader.readLine();
            int[] scores = new int[3];

            for (int i = 0; i < 3; i++) {
                scores[i] = Integer.parseInt(reader.readLine());
            }

            double average = calculateAverage(scores);

            System.out.println("학생 이름: " + studentName);
            System.out.println("평균 성적: " + average);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double calculateAverage(int[] scores) {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.length;
    }
}


