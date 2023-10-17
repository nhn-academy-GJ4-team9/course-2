package org.example;

public class Ex2_7 {
    public static void main(String[] args) {
        String name;
        int test1score;
        int test2score;
        int test3score;
        double average;

        TextIO.readFile("/Users/drakedog/Desktop/Chapter2/src/main/java/org/example/testdata.txt");
        name = TextIO.getln();
        test1score = TextIO.getlnInt();
        test2score = TextIO.getlnInt();
        test3score = TextIO.getlnInt();
        average = (test1score + test2score + test3score) / 3;
        TextIO.putf("%s got average %1.2f",name,average);
    }
}
