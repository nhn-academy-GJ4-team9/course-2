package Ex_01;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> arrayList = arrayListInit(10,10);

        System.out.println(arrayList);

    }

    public static List<Integer> arrayListInit(int max, int size){
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int element = (int) (Math.random() * max) + 1;
            arrayList.add(element);
        }
        return arrayList;
    }
}