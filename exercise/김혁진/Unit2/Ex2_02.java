public class Ex2_02 {
    public static void main(String[] args) {
        int firstNum = (int)(Math.random()*6);
        int secondNum = (int)(Math.random()*6);
        int totalNum = firstNum + secondNum;

        System.out.println("첫 번째 주사위 : " + firstNum);
        System.out.println("두 번째 주사위 : " + secondNum);
        System.out.println("총 주사위 값 : " + totalNum);
    }
}
