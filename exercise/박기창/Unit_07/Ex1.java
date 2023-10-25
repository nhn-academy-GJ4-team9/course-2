package org.example;

import java.util.ArrayList;
import java.util.List;

public class Ex1 {


    public static void main(String[] args) {
        System.out.println("10 integers chosen from the range 1 to 100:");
        System.out.println(makeRandomInts(10, 100));
        System.out.println();
        System.out.println("10 integers chosen from the range 1 to 10:");
        System.out.println(makeRandomInts(10, 10));
        System.out.println();
        System.out.println("25 integers chosen from the range 1 to 10000:");
        System.out.println(makeRandomInts(25, 10000));
        System.out.println();
        System.out.println("End with an exception!");
        try {
            System.out.println(makeRandomInts(10, 9));
        } catch (IllegalArgumentException e) {
            System.out.println("count가 range 보다 큼");
        }


    }

    /**
     * 입력 받은 count수 만큼 list에 서로 다른 요소를 삽입하는 메서드
     * 요소의 범위는 1 부터 range
     *
     * @param count
     * @param range
     * @return
     */
    public static List<Integer> makeRandomInts(int count, int range) {

        List<Integer> list = new ArrayList<>();

        if(count> range){
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < count; i++) {
            int random = (int) (Math.random() * range) + 1;
            if (!list.contains(random)) {
                list.add(random);
            } else {
                i--;
            }
        }


        return list;

    }
}
