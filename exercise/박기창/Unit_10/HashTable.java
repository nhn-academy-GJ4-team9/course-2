package org.example;
public class HashTable {

    private static class ListNode {
        String key;
        String value;
        ListNode next;  // Pointer to next node in the list;
        // A null marks the end of the list.
    }

    private ListNode[] table;  // The hash table, represented as
    // an array of linked lists.

    private int count;  // The number of (key,value) pairs in the
    // hash table.

    public HashTable(int initialSize) {
        if (initialSize <= 0)
            throw new IllegalArgumentException("Illegal table size");
        table = new ListNode[initialSize];
    }

    void dump() {
        System.out.println();
        for (int i = 0; i < table.length; i++) {
            System.out.print(i + ":");
            ListNode list = table[i]; // For traversing linked list number i.
            while (list != null) {
                System.out.print("  (" + list.key + "," + list.value + ")");
                list = list.next;
            }
            System.out.println();
        }
    } // end dump()


    public void put(String key, String value) {

        int bucket = hash(key); // Which location should this key be in?

        ListNode list = table[bucket];
        while (list != null) {
            // Search the nodes in the list, to see if the key already exists.
            if (list.key.equals(key))
                break;
            list = list.next;
        }

        if (list != null) {
            list.value = value;
        }
        else {
            if (count >= 0.75*table.length) {
                resize();
                bucket = hash(key);
            }
            ListNode newNode = new ListNode();
            newNode.key = key;
            newNode.value = value;
            newNode.next = table[bucket];
            table[bucket] = newNode;
            count++;  // Count the newly added key.
        }
    }


    public String get(String key) {

        int bucket = hash(key);
        ListNode list = table[bucket];  // For traversing the list.
        while (list != null) {
            if (list.key.equals(key))
                return list.value;
            list = list.next;  // Move on to next node in the list.
        }
        return null;
    }
    public void remove(String key) {

        int bucket = hash(key);  // At what location should the key be?

        if (table[bucket] == null) {
            return;
        }

        if (table[bucket].key.equals(key)) {
            table[bucket] = table[bucket].next;
            count--; // Remove new number of items in the table.
            return;
        }

        ListNode prev = table[bucket];
        ListNode curr = prev.next;
        while (curr != null && ! curr.key.equals(key)) {
            curr = curr.next;
            prev = curr;
        }

        if (curr != null) {
            prev.next = curr.next;
            count--;  // Record new number of items in the table.
        }
    }


    /**
     * Test whether the specified key has an associated value in the table.
     * @param key The key that we want to search for.
     * @return true if the key exists in the table, false if not
     */
    public boolean containsKey(String key) {

        int bucket = hash(key);  // In what location should key be?

        ListNode list = table[bucket];  // For traversing the list.
        while (list != null) {
            // If we find the key in this node, return true.
            if (list.key.equals(key))
                return true;
            list = list.next;
        }

        // If we get to this point, we know that the key does
        // not exist in the table.

        return false;
    }


    /**
     * Return the number of key/value pairs in the table.
     */
    public int size() {
        return count;
    }


    private int hash(Object key) {
        return (Math.abs(key.hashCode())) % table.length;
    }

    private void resize() {
        ListNode[] newtable = new ListNode[table.length*2];
        for (int i = 0; i < table.length; i++) {
            ListNode list = table[i]; // For traversing linked list number i.
            while (list != null) {
                ListNode next = list.next;
                int hash = (Math.abs(list.key.hashCode())) % newtable.length;
                list.next = newtable[hash];
                newtable[hash] = list;
                list = next;  // Move on to the next node in the OLD table.
            }
        }
        table = newtable;  // Replace the table with the new table.
    } // end resize()


} // end class HashTable
