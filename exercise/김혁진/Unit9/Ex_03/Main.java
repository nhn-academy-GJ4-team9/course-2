package Ex_03;

public class Main {

    static class ListNode {
        int data;
        ListNode next;

    }

    static ListNode reverse(ListNode list) {
        ListNode head = null;
        while (list != null) {
            ListNode newNode = new ListNode();
            newNode.data = list.data;
            newNode.next = head;
            head = newNode;
            list = list.next;
        }
        return head;
    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(" " + node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {

        ListNode list = null;
        ListNode reversedList;

        int ct = 0;

        while (true) {
            printList(list);
            reversedList = reverse(list);
            System.out.print("The reversed list: ");
            printList(reversedList);
            System.out.println();
            ct++;
            if (ct == 6) {
                break;
            }
            ListNode head = new ListNode();
            head.data = (int) (Math.random() * 100);
            head.next = list;
            list = head;
        }

    }
}
