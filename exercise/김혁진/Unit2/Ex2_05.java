import java.util.Scanner;

public class Ex2_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("계란 몇개 있나요?");
        int eggs = scanner.nextInt();
        System.out.println("계란은 " + eggs / 144 + "그로스 " + eggs % 144 / 12 + "다스 " + eggs % 12 + "개 있습니다.");

    }
}
