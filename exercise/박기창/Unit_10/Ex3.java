package org.example;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
            HashTable table = new HashTable(2);  // Initial size of table is 2.
            String key,value;
            while (true) {
                System.out.println("\nMenu:");
                System.out.println("   1. test put(key,value)");
                System.out.println("   2. test get(key)");
                System.out.println("   3. test containsKey(key)");
                System.out.println("   4. test remove(key)");
                System.out.println("   5. show complete contents of hash table.");
                System.out.println("   6. EXIT");
                System.out.print("Enter your command:  ");
                switch (scanner.nextInt()) {

                    case 1:
                        scanner.nextLine();
                        System.out.print("\n   Key = ");
                        key = scanner.nextLine();

                        System.out.print("   Value = ");
                        value = scanner.nextLine();
                        table.put(key,value);
                        break;
                    case 2:
                        scanner.nextLine();
                        System.out.print("\n   Key = ");
                        key = scanner.nextLine();
                        System.out.println("   Value is " + table.get(key));
                        break;
                    case 3:
                        scanner.nextLine();
                        System.out.print("\n   Key = ");
                        key = scanner.nextLine();
                        System.out.println("   containsKey(" + key + ") is "
                                + table.containsKey(key));
                        break;
                    case 4:
                        scanner.nextLine();
                        System.out.print("\n   Key = ");
                        key = scanner.nextLine();
                        table.remove(key);
                        break;
                    case 5:
                        table.dump();
                        break;
                    case 6:
                        return;  // End program by returning from main()
                    default:
                        System.out.println("   Illegal command.");
                        break;
                }
                System.out.println("\nHash table size is " + table.size());
            }
        }
    }

}
