import textio.TextIO;

public class Ex2_07 {

    public static void main(String[] args) {
        int score = 0;
        double average;
        TextIO.readFile("testdata.txt");
        String name = TextIO.getln();

        for (int i = 0; i < 3; i++) {
            score += TextIO.getlnInt();
        }
        average = score / 3.0;
        System.out.println(name);
        System.out.println(average);
    }
}
