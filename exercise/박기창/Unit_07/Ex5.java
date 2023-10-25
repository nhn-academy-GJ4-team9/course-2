package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex5 {


    /**
     * 리스트 인덱스 요소 위치 바꾸는 메서드
     * @param list
     * @param i
     * @param min
     * @param index
     */
    public static void change(List<Integer> list, int i,int min,int index){
        int temp=list.get(i);
        list.set(i,min);
        list.set(index,temp);
    }
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        System.out.println("숫자를 입력하시오 : 0을 입력하면 종료");
        try (Scanner scanner = new Scanner(System.in)) {
            int count = 0;
            while (count < 100) {
                count++;
                int x = scanner.nextInt();
                if (x == 0) {
                    break;
                }
                list.add(x);
            }

            for (int i = 0; i < list.size(); i++) {
                int min=list.get(i);
                int index=i;
                for (int j = i; j < list.size(); j++) {
                    if (min>list.get(j)){
                        min=list.get(j);
                        index=j;
                    }
                }


                change(list,i,min,index);


            }


            System.out.println(list);
        }
    }
}
