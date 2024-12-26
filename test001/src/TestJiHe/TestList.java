package TestJiHe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class TestList {
    public static void main(String[] args) {

        //Collection单列数据；Map双列数据{存放k-v}
        ArrayList<String> str = new ArrayList<>();
        str.add("张三");
        str.add("王五");
        System.out.println(str);

        HashMap<String, Integer> ren = new HashMap<>();
        ren.put("张三", 20);
        ren.put("li", 35);
        System.out.println(ren);
        System.out.println("-------------------------");

        Iterator<String> iterator1 = ren.keySet().iterator();
        while (iterator1.hasNext()) {
            String knext = iterator1.next();
            System.out.println(knext);
        }
        /*
        所有实现了Collection接口的类都有一个iterator！
        迭代器的使用！
         */
        Iterator<String> iterator = str.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        //iterator快捷键 ： itit
        //现实所有快捷键：ctrl + j

        System.out.println("-------------------------");
        //增强for循环直接作用在数组上
        //数组Array和集合Collection是完全两个不同的概念
        int[] nms = {20, 3, 6, 6, 8, 90};
        for (int nm : nms) {
            System.out.println(nm);
        }

        //作用在集合上
        for (String s : str) {
            System.out.println(s);
        }
        for (Integer age : ren.values()) {
            System.out.println(age);
        }
        System.out.println("------------------------");
        /*
        练习
        添加10个以上的元素(比如String "hello")，
        在2号位插入一个元素"韩顺平教育”，获得第5个元素，删除第6个元素，修改第7个元素，在使用迭代器遍历集合，要求:使用List的实现类ArrayList完成。
         */
        ArrayList<String> list1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list1.add("hello");
        }
        System.out.println(list1.size());

        list1.add(1, "lisisb");
        System.out.println(list1);
        System.out.println(list1.get(4));
        list1.set(6, "myhello");
        list1.remove(5);
        System.out.println(list1);

        Iterator<String> iterator2 = list1.iterator();
        while (iterator2.hasNext()) {
            String list1next = iterator2.next();
            System.out.print(list1next + "\t");
        }
        //sort（list1），冒泡排序，这里不再写
        System.out.println("\n"+"----------------");

        //ArrayList扩容机制
        //        ArrayList arrayList = new ArrayList();
        ArrayList arrayList1 = new ArrayList(8);
        for (int i = 1; i <= 10; i++) {
            arrayList1.add(i);
        }
        //使用for给list集合添加 11-15数据
        for (int i = 11; i <= 15; i++) {
            arrayList1.add(i);
        }
        arrayList1.add(100);
        arrayList1.add(200);
        arrayList1.add(null);

    }
}
