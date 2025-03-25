package TestJiHe;

public class HashSetStructure {
    public static void main(String[] args) {
        //模拟一个HashSet的底层（HashMap 的底层结构）
        Node[] table = new Node[16];
        Node hsp = new Node("hsp",null);

        table[2] = hsp;
        Node jack = new Node("jack", null);
        hsp.next = jack;
        Node queen = new Node("queen", null);
        jack.next = queen;

        System.out.println(table);
    }
}
class Node{
    Object item;
    Node next;

    public Node(Object item, Node next) {
        this.item = item;
        this.next = next;
    }
}
