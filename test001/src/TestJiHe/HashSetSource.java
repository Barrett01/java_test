package TestJiHe;

import java.util.HashSet;

public class HashSetSource {
    public static void main(String[] args){
        HashSet<Object> hashSet = new HashSet<>();
        hashSet.add("java");
        hashSet.add("python");
        hashSet.add("java");
        System.out.println(hashSet);
        /*
        hashset的底层源码解读
        1，先执行HashSet的构造器

         */
    }
}
