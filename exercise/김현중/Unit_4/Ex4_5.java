package org.example;

public class Ex4_5 {
    public static ArrayProcessor counter(double value){
        return array -> {
            int count = 0;
            for(int i = 0; i <array.length;i++){
                if(array[i]==value){
                    count++;
                }
            }
            return count;

        };
    }

    public static final ArrayProcessor maxValue = array -> {
        double max = array[0];
        for(int i = 0; i<array.length;i++){
            if(array[i]>max)
                max = array[i];

        }
        return max;
    };
    public static final ArrayProcessor minValue = array -> {
        double min = array[0];
        for (int i = 0; i<array.length;i++){
            if(array[i]<min)
                min = array[i];
        }
        return min;
    };
    public static final ArrayProcessor sumOfValues = array -> {
        double sum = 0;
        for(int i = 0 ; i<array.length;i++){
            sum += array[i];
        }
        return sum;
    };
    public static final ArrayProcessor avgOfValues = array -> sumOfValues.apply(array)/array.length;

    public static void main(String[] args) {
        double[] list1 = {1,2,3,4,5,6,7,8,9,10};
        double[] list2 = {17.0,3.14,17.0,-3.4,17.0,42.0,29.2,31.4};
        System.out.println("Max of list1  :" + maxValue.apply(list1));
        System.out.println("Max of list1  :" + maxValue.apply(list1));
        System.out.println("Min of list1  :" + minValue.apply(list1));
        System.out.println("Min of list2  :" + minValue.apply(list2));
        System.out.println("Sum of list1  : " + sumOfValues.apply(list1));
        System.out.println("Avg og list2  : " + avgOfValues.apply(list2));
        System.out.println("Count of 1 in list1 : "+ counter(1).apply(list1));

    }
}
