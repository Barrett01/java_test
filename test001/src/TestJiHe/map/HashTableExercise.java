package TestJiHe.map;

import java.util.Hashtable;

/*
HashTable的扩容机制
 */
public class HashTableExercise {
    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable();
        hashtable.put("join",10);
        hashtable.put("join2",20);
        hashtable.put("join3",30);
        hashtable.put("join4",40);
        hashtable.put("join5",10);
        hashtable.put("join2",60);
//        hashtable.put("join3",null);//NullPointerException Hashtable不能出现null值和null键
//        hashtable.put(null,10);
        hashtable.put("join6",60);
        hashtable.put("join7",70);
        hashtable.put("join8",80);
        hashtable.put("join9",90);
        hashtable.put("join10",10);
        hashtable.put("join11",11);
        hashtable.put("join12",12);
        hashtable.put("join13",13);
        hashtable.put("join14",14);
        hashtable.put("join15",15);
        hashtable.put("join16",16);
        hashtable.put("join17",17);
        hashtable.put("join18",18);

        System.out.println(hashtable);
        /*
        1,底层有数组Hashtable$Entry[] 初始化大小为11
        2，临界值 threshold 8 = 11 *0.75
         */
    }
}
