package org.example;

public class Dice {
    public static void main(String[] args) {
        int num = (int)(Math.random()*6) + 1;
        if(num == 1){
            System.out.println("주사위는 1입니다.");
        }else if(num == 2){
            System.out.println("주사위는 2입니다.");
        }else if(num == 3){
            System.out.println("주사위는 3입니다.");
        }else if(num == 4){
            System.out.println("주사위는 4입니다.");
        }else if(num == 5){
            System.out.println("주사위는 5입니다.");
        }else {
            System.out.println("주사위는 6입니다.");
        }

        int number = (int)(Math.random()*6) + 1;
        if(number == 1){
            System.out.println("주사위는 1입니다.");
        }else if(number == 2){
            System.out.println("주사위는 2입니다.");
        }else if(number == 3){
            System.out.println("주사위는 3입니다.");
        }else if(number == 4){
            System.out.println("주사위는 4입니다.");
        }else if(number == 5){
            System.out.println("주사위는 5입니다.");
        }else {
            System.out.println("주사위는 6입니다.");
        }
        System.out.println(num + number);
    }
}
