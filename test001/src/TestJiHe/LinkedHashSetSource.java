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
        /*
        1，加入和取出顺序一致
        2，底层维护的是一个LinkedHashMap
        3，底层结构（数据+双向链表）
        4，添加第一次，直接将table扩容到16 存放的节点类型为linkedhashmap$entry
        5,数组是HashMap$Node[]存放的元素/数据是linkedhashmap$entry类型
         */
    }
}
