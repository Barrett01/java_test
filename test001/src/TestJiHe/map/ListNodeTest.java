package TestJiHe.map;

public class ListNodeTest {
    static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //定义一个方法
    private static void insertNode(ListNode node, int data) {
        if (node == null) {
            return;
        }
        //创建一个新节点
        ListNode newdata = new ListNode(data);
        ListNode cur = node;//赋值给cur ，让cur来做移动指针
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = newdata;//为空了进行赋值{链表追加}
    }

    private static void printList(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        //添加链表{next追加}
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        //指针变量赋值{指针移动}
        ListNode temp = head;
        temp = temp.next;//移动指针
        temp.next = new ListNode(100);//通过temp指针变量更改节点的指针域：截断链表

        head.next.next = null;//与上面同理

        System.out.println("=========================");
        ListNode listNode = new ListNode(10);
        insertNode(listNode, 1);
        insertNode(listNode, 2);
        insertNode(listNode, 3);
        insertNode(listNode, 4);
        insertNode(listNode, 5);

        System.out.println("=========================");

        printList(listNode);
    }


}

