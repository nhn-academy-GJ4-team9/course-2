package org.example;

public class Ex4_2 {
    public static void main(String[] args) {
        System.out.println(hexToDec("7ab"));
        System.out.println(hexToDec("8j"));
    }

    public static int hexValue(char hex) {
        int val = 0;
        if (hex >= '0' && hex <= '9') {
            val += hex - 48;
        } else if (hex >= 'A' && hex <= 'F') {
            val += hex - 55;
        } else if (hex >= 'a' && hex <= 'f') {
            val += hex - 87;
        } else {
            return -1;

        }
        return val;
    }

    public static int hexToDec(String hex) {
        for(int i = 0; i<hex.length();i++){
            if(hexValue(hex.charAt(i)) == -1){
                System.out.println("not hex try again");
                System.exit(1);
            }
        }
        int val = 0;
        for (int i = 0 ; i< hex.length();i++){
            val = val*16 + hexValue(hex.charAt(i));
        }
        return val;
    }

}
