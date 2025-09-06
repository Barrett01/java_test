package LeetCode;

/*
两数相加-----链表
 */
public class addTwoNumbers {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //方法两数之和
    public static ListNode addTwoNumb(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode cur = null;
        int carry = 0;
        //循环写入
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val :0;
            int n2 = l2 != null ? l2.val :0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head  = cur = new ListNode(sum % 10);
            }else {
                cur.next = new ListNode(sum % 10);
                cur = cur.next;//指针移动
            }
            carry = sum / 10; //计算进一
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(6);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(8);

        ListNode l2 = new ListNode(4);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(7);
        ListNode listNode = addTwoNumb(l1, l2);
        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }

    }
}
