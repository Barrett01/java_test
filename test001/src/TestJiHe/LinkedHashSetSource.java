package TestJiHe;

import java.util.LinkedHashSet;

public class LinkedHashSetSource {
    public static void main(String[] args) {
        //分析一下LinkedHashSet的底层源码
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(1);
        linkedHashSet.add(new String("hello"));
        linkedHashSet.add(new String("world"));
        linkedHashSet.add(2);
        linkedHashSet.add(1);
        linkedHashSet.add("hep");
        System.out.println(linkedHashSet);
    }
}
