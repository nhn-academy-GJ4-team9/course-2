import java.io.IOException;
import java.util.Scanner;
/**
 * Problem
 * 스트림에서 문자열 추출
 */
public class Ex_04 {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.print("입력 : ");
            String inputStream = scanner.nextLine();
            scanner.close();
            String[] words = searchWords(inputStream);
            for (String word : words) {
                System.out.println(word);
            }
        }
    }

    /**
     * 올바른 문자만 추출하는 메서드
     * @param inputStream 입력값
     * @return 추출한 단어
     */
    public static String[] searchWords(String inputStream) {
        //정규표현식을 사용한 공백 대체 공부하기
        String[] words = inputStream.replaceAll("[^a-zA-Z'\\s]", " ")
                .replaceAll("\\s+", " ")
                .split(" ");

        return words;
    }
}
