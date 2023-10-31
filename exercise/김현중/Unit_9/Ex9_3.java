package org.example;

public class Ex9_3 {
    static ListNode copy(ListNode list){
        ListNode myList = null;
        ListNode pointer = list;
        while (pointer != null){
            ListNode listNode = new ListNode();
            listNode.item = pointer.item;
            listNode.next = myList;
            myList = listNode;
            pointer = pointer.next;
        }
        return myList;
    }
    static class ListNode{
        int item;
        ListNode next;

        @Override
        public String toString() {
            return "ListNode{" +
                    "item=" + item +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        ListNode a = new ListNode();
        ListNode b = new ListNode();
        ListNode c= new ListNode();
        a.item = 1;
        a.next =b;
        b.item = 2;
        b.next=c;
        c.item= 3;
        c.next=null;

        System.out.println(copy(a));
    }

}
