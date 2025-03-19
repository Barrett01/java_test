package TestJiHe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//练习list方法

public class ListExercise {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("hello");
        list.add("world");
        list.add("hello");
        list.add("world");
        list.add("hello");
        list.add("world");
        list.add("hello");
        list.add("world");
        list.add("hello");
        list.add("world");
        list.add("hello");
        list.add("world");
        System.out.println(list);
        list.add(1,"xiaoHH" );
        System.out.println(list);
        System.out.println(list.get(4));
        list.remove(6);
        list.set(6,"HH");
        System.out.println(list);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
