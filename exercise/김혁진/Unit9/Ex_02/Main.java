package Ex_02;

import static Ex_02.SortTreeDemo.root;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        String inputFilePath = "/test.txt";

        ArrayList<String> words = strFileRead(inputFilePath);
        SortTreeDemo sortTreeDemo = new SortTreeDemo();
        for (int i = 0; i < words.size(); i++) {
            sortTreeDemo.treeInsert(words.get(i));
        }
        sortTreeDemo.treeList(root);

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
        }

        return words;
    }

}