package Ex_03;

/**
 * get(key) , put(key,value) , Remove(key) , containKey(key) 및 size()
 */
public class MyHashTable<K, V> {
    class Node<K, V> {
        private K key;
        private V data;
        Node next;

        public Node(K key, V data, Node next) {
            this.key = key;
            this.data = data;
            this.next = next;
        }

        K getKey() {
            return key;
        }

        V getValue() {
            return data;
        }
    }

    private int size;
    private Node<K, V>[] table;


    public MyHashTable(int capacity) {
        try {
            table = new Node[capacity];
            this.size = capacity;
        } catch (OutOfMemoryError e) {
            this.size = 0;
        }
    }

    public int hashValue(Object key) {
        return key.hashCode() % size;
    }

    public int put(K key, V data) {
        int hash = hashValue(key);
        Node<K, V> p = table[hash];

        while (p != null) {

            if (p.getKey().equals(key)) {
                return 1;
            }
            p = p.next;
        }
        Node<K,V> temp = new Node<K,V> (key, data, table[hash]);
        table[hash] = temp;
        return 0;
    }


    public V get(K key){
        int hash = hashValue(key);
        Node<K,V> p = table[hash];

        while(p!=null){
            if(p.getKey().equals(key))
                return p.getValue();
            p=p.next;
        }
        return null;
    }

    public int remove(K key) {
        int hash = hashValue(key);
        Node<K, V> p = table[hash];
        Node<K,V> pp = null;

        while (p != null) {
            if (p.getKey().equals(key)) {
                if (pp == null)
                    table[hash] = p.next;
                else
                    pp.next = p.next;
                return 0;
            }
            pp = p;
            p = p.next;
        }
        return 1;
    }

    public int size() {
        return size;
    }


    public static void main(String[] args) {
        MyHashTable ht = new MyHashTable(3);
        ht.put("1", "k");
        ht.put("2", "H");
        ht.put("3", "J");
        System.out.println( ht.get("1"));
        ht.remove("2");
        System.out.println(ht.get("2"));
        System.out.println(ht.get("3"));
        System.out.println(ht.size());
    }


}
