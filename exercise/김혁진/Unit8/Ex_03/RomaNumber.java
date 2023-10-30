package Ex_03;

public class RomaNumber {
    private static int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static String[] letters = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private String romaStr;
    private int arabiaInt;

    public RomaNumber(String inputRoma) {
        this.romaStr = inputRoma;
    }

    public RomaNumber(int inputArabian) {
        this.arabiaInt = inputArabian;
    }

    public int toInt() {
        int result = 0;
        int index = 0;

        while (index < romaStr.length()) {
            for (int i = 0; i < letters.length; i++) {
                String letter = letters[i];
                if (index + letter.length() <= romaStr.length() &&
                        romaStr.substring(index, index + letter.length()).equals(letter)) {
                    result += numbers[i];
                    index += letter.length();
                    break;
                }
            }
        }

        return result;
    }

    public String toStr() {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (this.arabiaInt != 0) {
            if (this.arabiaInt >= numbers[index]) {
                sb.append(letters[index]);
                this.arabiaInt -= numbers[index];
            } else{index++;}
        }
        return sb.toString();
    }
}
