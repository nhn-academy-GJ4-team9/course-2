package Ex_01;

import java.util.Map;
import java.util.TreeMap;

public class PhoneDirectory {

    private TreeMap<String, String> data;

    public PhoneDirectory(){
        TreeMap<String, String> data = new TreeMap<>();
    }

    private void putNumber(String name, String number) {
        if(name == null || number == null){
            throw new IllegalArgumentException("이름 , 번호 null 값 안됨");
        }
        data.put(name, number);
    }

    public void print() {
        for ( Map.Entry<String,String> entry : data.entrySet() )
            System.out.println( entry.getKey() + ":  " + entry.getValue() );
    }

    private String getNumber(String str) {
        return data.get(str);
    }

    public static void main(String[] args) {
        PhoneDirectory directory = new PhoneDirectory();
        directory.putNumber("Fred", "555-1234");
        directory.putNumber("Barney", "555-2345");
        directory.putNumber("Wilma", "555-3456");
        System.out.println();
        directory.print();
        System.out.println();
        System.out.println("Number for Fred is " + directory.getNumber("Fred"));
        System.out.println("Number for Wilma is " + directory.getNumber("Wilma"));
        System.out.println("Number for Tom is " + directory.getNumber("Tom"));
    }

}