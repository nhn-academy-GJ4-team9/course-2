import java.util.Scanner;

public class Ex2_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;
        String firstName;
        String lastName;

        System.out.println("이름과 성을 공백으로 구분하여 입력하세요.");
        name = scanner.nextLine();

        int space = name.indexOf(' ');
        firstName = name.substring(0, space);
        lastName = name.substring(space + 1);

        System.out.println("이름 : " + firstName + " 글자수 : " + firstName.length());
        System.out.println("성 : " + lastName + " 글자수 : " + lastName.length());
        System.out.println("이니셜 :" +firstName.charAt(0) + lastName.charAt(0));
    }
}
