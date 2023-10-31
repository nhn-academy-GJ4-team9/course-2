package org.example;

public class Ex9_3 {

    public static void main(String[] args) {
        ListNode originalList = createSampleList();

        ListNode reversedList = reverseCopyList(originalList);

        printList(reversedList);
    }

    static class ListNode {
        int item;
        ListNode next;

        ListNode(int item) {
            this.item = item;
        }
    }

    static ListNode reverseCopyList(ListNode original) {
        ListNode reversed = null;

        while (original != null) {
            ListNode newNode = new ListNode(original.item);
            newNode.next = reversed;
            reversed = newNode;
            original = original.next;
        }

        return reversed;
    }

    static void printList(ListNode list) {
        while (list != null) {
            System.out.print(list.item + " ");
            list = list.next;
        }
        System.out.println();
    }

    static ListNode createSampleList() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;

        return node1;
    }
}
