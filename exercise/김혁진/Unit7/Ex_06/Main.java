package Ex_06;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        String inputFilePath = "/test.txt";
        String outputFilePath = "resources/output.txt";

        ArrayList<String> words = strFileRead(inputFilePath);

        Collections.sort(words);

        writeToFile(outputFilePath, words);

        System.out.println("실행 완료");
    }

    private static ArrayList<String> strFileRead(String filePath) {
        ArrayList<String> words = new ArrayList<>();

        try (InputStream inputStream = Main.class.getResourceAsStream(filePath);
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] wordArray = line.split("[^a-zA-Z']+");
                for (String word : wordArray) {
                    word = word.toLowerCase();
                    if (!words.contains(word)) {
                        words.add(word);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } //SecurityException, UnsupportedEncodingException 도 있을 수 있음

        return words;
    }

    private static void writeToFile(String filePath, ArrayList<String> words) {
        try (PrintWriter writer = new PrintWriter(filePath)) {
            for (String word : words) {
                writer.println(word);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
