package com.example.chapter8;

import java.util.Scanner;

public class Ex8_3 {
    static final String[] ROM = {"M","D","C","L","X","V","I"};
    static final int[] ARAB = {1000,500,100,50,10,5,1};

    public static void main(String[] args) {
        try(Scanner sc  = new Scanner(System.in)){
            System.out.println("input one character for getting arabic value");
            String str = sc.nextLine();
            String line;
            while (true){
                System.out.println("it is : ");
                System.out.println(romToArab(str));
                System.out.println();
                System.out.println("try again? or space to end");
                line = sc.nextLine();
                if(line.equals(" "))
                    break;
            }
        }
    }

    public static int romToArab (String str){
        int val = 0;
        for(int i = 0 ; i<ROM.length;i++){
            assert !str.equals(ROM[i]) : "not valid roman";
            if(str.equals(ROM[i])){
                val = ARAB[i];
            }
        }
        return val;
    }
    public static StringBuilder arabToRom(int n){
        StringBuilder rom = new StringBuilder();
        for(int i = 0 ; i<ARAB.length;i++){
            assert !(n==ARAB[i]) : " not valid arabic number";
            if(ARAB[i]==n){
                rom.append(ROM[i]);
            }
        }
        return rom;
    }
}
