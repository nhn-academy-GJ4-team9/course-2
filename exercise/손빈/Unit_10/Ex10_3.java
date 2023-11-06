package org.example;

public class Ex10_3 {

    private static class ListNode {
        String key;
        String value;
        ListNode next;
    }

    private ListNode[] table;

    private int count;

    public void HashTable() {
        table = new ListNode[64];
    }

    public void HashTable(int initialSize) {
        if (initialSize <= 0)
            throw new IllegalArgumentException("Illegal table size");
        table = new ListNode[initialSize];
    }

    void dump() {
        System.out.println();
        for (int i = 0; i < table.length; i++) {
            System.out.print(i + ":");
            ListNode list = table[i];
            while (list != null) {
                System.out.print("  (" + list.key + "," + list.value + ")");
                list = list.next;
            }
            System.out.println();
        }
    }

    public void put(String key, String value) {
        assert key != null : "The key must be non-null";
        int bucket = hash(key);
        ListNode list = table[bucket];
        while (list != null) {
            if (list.key.equals(key))
                break;
            list = list.next;
        }
        if (list != null) {
            list.value = value;
        } else {
            if (count >= 0.75 * table.length) {
                resize();
                bucket = hash(key);
            }
            ListNode newNode = new ListNode();
            newNode.key = key;
            newNode.value = value;
            newNode.next = table[bucket];
            table[bucket] = newNode;
            count++;
        }
    }

    public String get(String key) {
        int bucket = hash(key);
        ListNode list = table[bucket];
        while (list != null) {
            if (list.key.equals(key))
                return list.value;
            list = list.next;
        }
        return null;
    }

    public void remove(String key) {
        int bucket = hash(key);
        if (table[bucket] == null) {
            return;
        }
        if (table[bucket].key.equals(key)) {
            table[bucket] = table[bucket].next;
            count--;
            return;
        }
        ListNode prev = table[bucket];
        ListNode curr = prev.next;
        while (curr != null && !curr.key.equals(key)) {
            curr = curr.next;
            prev = curr;
        }
        if (curr != null) {
            prev.next = curr.next;
            count--;
        }
    }

    public boolean containsKey(String key) {
        int bucket = hash(key);
        ListNode list = table[bucket];
        while (list != null) {
            if (list.key.equals(key))
                return true;
            list = list.next;
        }
        return false;
    }

    public int size() {
        return count;
    }

    private int hash(Object key) {
        return (Math.abs(key.hashCode())) % table.length;
    }

    private void resize() {
        ListNode[] newtable = new ListNode[table.length * 2];
        for (int i = 0; i < table.length; i++) {
            ListNode list = table[i];
            while (list != null) {
                ListNode next = list.next;
                int hash = (Math.abs(list.key.hashCode())) % newtable.length;
                list.next = newtable[hash];
                newtable[hash] = list;
                list = next;
            }
        }
        table = newtable;
    }
}
