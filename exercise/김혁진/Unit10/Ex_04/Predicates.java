package Ex_04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class Predicates {

    public static <T> void remove(Collection<T> coll, Predicate<T> pred){
        List<T> list = new ArrayList<>(coll);

        Iterator<T> iterator = list.iterator();
        while(iterator.hasNext()){
            T item = iterator.next();
            if(pred.test(item)){
                iterator.remove();
            }
        }
        System.out.println(list);
    }

    public static <T> void retain(Collection<T> coll, Predicate<T> pred){
        List<T> list = new ArrayList<>(coll);
        Iterator<T> iterator = list.iterator();
        while(iterator.hasNext()){
            T item = iterator.next();
            if(!pred.test(item)){
                iterator.remove();
            }
        }
        System.out.println(list);
    }

    public static <T> List<T> collect(Collection<T> coll, Predicate<T> pred){
        List<T> list = new ArrayList<>();
        for ( T item : coll ) {
            if (pred.test(item))
                list.add(item);
        }
        return list;
    }

    public static <T> int find(ArrayList<T> list, Predicate<T> pred){
        int index = 0 ;
        for(T item : list){
            index++;
            if(pred.test(item)){
                return index;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        Collection<Integer> A = Arrays.asList(1, 2, 3, 4, 5, 6);
        Predicate<Integer> B = (x) -> (x % 2 == 0);

        remove(A,B);
        retain(A,B);

        List<Integer> result = collect(A,B);
        System.out.println(result);

        ArrayList<Integer> Alist = new ArrayList<>(Arrays.asList(1,2,3,4,5));

        System.out.println( find(Alist,B));
    }
}
