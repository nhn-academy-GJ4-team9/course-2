package org.example;

import java.util.Arrays;

public class Ex10_1 {
    private static class PhoneEntry {
        String name;
        String number;
    }

    private PhoneEntry[] data;
    private int dataCount;

    public void PhoneDirectory() {
        data = new PhoneEntry[1];
        dataCount = 0;
    }

    private int find( String name ) {
        for (int i = 0; i < dataCount; i++) {
            if (data[i].name.equals(name))
                return i;
        }
        return -1;
    }

    public String getNumber( String name ) {
        int position = find(name);
        if (position == -1)
            return null;
        else
            return data[position].number;
    }

    public void putNumber( String name, String number ) {
        if (name == null || number == null)
            throw new IllegalArgumentException("name and number cannot be null");
        int i = find(name);
        if (i >= 0) {

            data[i].number = number;
        }
        else {

            if (dataCount == data.length) {
                data = Arrays.copyOf( data, 2*data.length );
            }
            PhoneEntry newEntry = new PhoneEntry();
            newEntry.name = name;
            newEntry.number = number;
            data[dataCount] = newEntry;
            dataCount++;
        }
    }
    public static void main(String[] args) {

        Ex10_1 phoneDirectory = new Ex10_1();

        String aliceNumber = phoneDirectory.getNumber("Alice");
        String bobNumber = phoneDirectory.getNumber("Bob");
        String charlieNumber = phoneDirectory.getNumber("Charlie");

        System.out.println("Alice number: " + aliceNumber);
        System.out.println("Bob number: " + bobNumber);
        System.out.println("Charlie number: " + charlieNumber);
    }
}
