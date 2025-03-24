package TestJiHe;

import java.util.LinkedList;

/*
通过断点来看 linkedList的底层实现原理
 */
public class LinkedListCRUD {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(2);//看头节点，尾节点，next pre等的作用，怎么实现结点的指向！
        linkedList.add(22);
        linkedList.add(222);
        linkedList.add(2222);
        linkedList.add(22222);

        //指定删除节点
        linkedList.remove();//看看如何删除的

        linkedList.set(1,999);

        Object o = linkedList.get(1);
        System.out.println(linkedList);
        System.out.println("!:"+o);
    }
}
