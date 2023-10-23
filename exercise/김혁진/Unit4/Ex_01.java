import java.util.Scanner;

/**
 * Porblem
 * 문장의 첫글자마다 대문자로 바꿔주는 문
 * printCapitalized 메서드를 만들고 isLetter문 사용
 */
public class Ex_01 {
    public static void main(String[] args) {
        try (
                Scanner scanner = new Scanner(System.in)) {
            String beforeStr = scanner.nextLine();
            printCapitalized(beforeStr);
        }
    }

    public static String printCapitalized(String str) {
        char beforeChar = ' ';
        for (int i = 0; i < str.length(); i++) {
            char thisChar = str.charAt(i);
            if (!Character.isLetter(beforeChar) && Character.isLetter(thisChar)) {
                System.out.print(Character.toUpperCase(thisChar));
            } else {
                System.out.print(thisChar);
            }
            beforeChar = thisChar;
        }
        return str;
    }
}