package TestJiHe;

//双向链表的基本练习
public class LinkedList01 {
    public static void main(String[] args) {
        Node lz = new Node("老张");
        Node ll = new Node("老李");
        Node lw = new Node("老王");
        lz.next = ll;
        ll.next = lw;

        lw.pre = ll;
        ll.pre = lz;

        Node first = lz;
        Node last = lw;
        //遍历
        System.out.println("=======从头到位排序======");
        while (true) {
            if (first == null) {
                break;
            } else {
                System.out.println(first);
                first = first.next;
            }
        }
        System.out.println("=======从尾到头=======");
        while (true) {
            if (last == null) {
                break;//今日触发错误的点，break退出，return返回
            }
            System.out.println(last);
            last = last.pre;

        }
        //插入一个小人儿：hh;插入到双向链表；
        Node hh = new Node("黄浩");
        //插入倒数第二个位置
        first = lz;//让first再次制导老z
        hh.next = lw;
        hh.pre = ll;
        ll.next = hh;
        lw.pre = hh;
        System.out.println("=======从头到位排序======");
        while (true) {
            if (first == null) {
                break;
            } else {
                System.out.println(first);
                first = first.next;
            }
        }


    }
}

//定义一个Node类，Node对象，表示双向链表的一个结点
class Node {
    public Object item;//保存的数据
    public Node next;//指向下一个节点
    public Node pre;//指向前一个节点

    public Node(Object item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Node{" +
                "item=" + item +
                '}';
    }
}
