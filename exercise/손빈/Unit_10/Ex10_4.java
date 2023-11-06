package org.example;

import java.util.*;

public class Ex10_4 {
    private static Ex10_4 Predicates;

    public interface Predicate<T> {
        public boolean test( T obj );
    }
    public static <T> void remove(Collection<T> coll, Predicate<T> pred) {
        Iterator<T> iter = coll.iterator();
        while (iter.hasNext()) {
            T item = iter.next();
            if (pred.test(item))
                iter.remove();
        }
    }

    public static <T> void retain(Collection<T> coll, Predicate<T> pred) {
        Iterator<T> iter = coll.iterator();
        while (!iter.hasNext()) {
            T item = iter.next();
            if (pred.test(item))
                iter.remove();
        }
    }

    public static <T> List<T> collect(Collection<T> coll, Predicate<T> pred) {
        List <T> list = new ArrayList<>();
        Iterator<T> iter = coll.iterator();
        while (iter.hasNext()) {
            T item = iter.next();
            if (pred.test(item))
                list.add(item);
        }return list;
    }

    public static <T> int find(ArrayList<T> list, Predicate<T> pred) {
        Iterator<T> iter = list.iterator();
        int count = 0;
        while (iter.hasNext()) {
            T item = iter.next();
            if (pred.test(item)) {
                return count;
            }count++;
        }return -1;
    }
    static Collection<Integer> makeSet() {
        Collection<Integer> set = new TreeSet<Integer>();
        set.add(Integer.valueOf(32));
        set.add(Integer.valueOf(17));
        set.add(Integer.valueOf(142));
        set.add(Integer.valueOf(56));
        set.add(Integer.valueOf(1899));
        set.add(Integer.valueOf(57));
        set.add(Integer.valueOf(999));
        set.add(Integer.valueOf(86));
        set.add(Integer.valueOf(83));
        set.add(Integer.valueOf(100));
        return set;
    }
    public static void main(String[] args) {

        Collection<Integer> coll;

        List<Integer> result;
        Predicate<Integer> pred = i -> (i % 2 == 0);

        coll = makeSet();
        System.out.println("Original collection: " + coll);

        Predicates.remove(coll,pred);
        System.out.println("Remove evens: " + coll);

        coll = makeSet();
        Predicates.retain(coll,pred);
        System.out.println("Retain evens: " + coll);

        coll = makeSet();
        result = Predicates.collect(coll,pred);
        System.out.println("Collect evens: " + result);

        ArrayList<Integer> list = new ArrayList<Integer>();
        int i = Predicates.find(list,pred);
        System.out.println("Find first even: at index " + i);


        pred = n -> (n > 100);

        coll = makeSet();
        System.out.println("Original collection: " + coll);

        Predicates.remove(coll,pred);
        System.out.println("Remove big: " + coll);

        coll = makeSet();
        Predicates.retain(coll,pred);
        System.out.println("Retain big: " + coll);

        coll = makeSet();
        result = Predicates.collect(coll,pred);
        System.out.println("Collect big: " + result);

        list = new ArrayList<Integer>(coll);
        i = Predicates.find(list,pred);
        System.out.println("Find first big: at index " + i);

    }

}

