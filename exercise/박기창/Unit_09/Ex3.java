package org.example;

public class Ex3 {
    public static void main(String[] args) {

        ListNode a = new ListNode();
        ListNode b = new ListNode();
        ListNode c = new ListNode();
        ListNode d = new ListNode();
        a.item = 1;
        b.item = 2;
        c.item = 3;
        d.item = 4;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = null;

        ListNode reversedList;

        printList(a);
        System.out.println();
        reversedList = reverse(a);
        System.out.print("The reversed list: ");
        printList(reversedList);


    }

    static void printList(ListNode start) {
        ListNode runner;  // For running along the list.
        runner = start;
        System.out.print("(");
        while (runner != null) {
            System.out.print(" " + runner.item);
            runner = runner.next;
        }
        System.out.print(" )");
    } // end printList()


    static ListNode reverse(ListNode list) {
        ListNode rev = null;     // rev will be the reversed list.
        ListNode runner = list;  // For running through the nodes of list.
        while (runner != null) {
            // "Push" the next node of list onto the front of rev.
            ListNode newNode = new ListNode();
            newNode.item = runner.item;
            newNode.next = rev;
            rev = newNode;
            // Move on to the next node in the list.
            runner = runner.next;
        }
        return rev;
    } // end reverse()
}

class ListNode {
    int item;       // An item in the list.
    ListNode next;  // Pointer to the next node in the list.
}
