import java.util.Locale;
import java.util.Scanner;

public class Ex2_03 {
    public static void main(String[] args) {
        System.out.println("너의 이름은 ?");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.next();
        System.out.println("안녕 " + userName.toUpperCase() + " 만나서 반가워");
    }
}
