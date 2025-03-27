package TestJiHe;

import java.util.HashSet;

/*
实例测试
 */
public class HashSetIncrement {
    public static void main(String[] args) {
        /*
        HashSet底层是HashMap，第一次添加时，table扩容到16
        临界值是16*0.75=12
        如果达到临界值 就会扩容16*2 = 32
        新的临界值32*2=64
         */
        //以为为演示
        HashSet hh = new HashSet();
//        for (int i = 0; i <80 ; i++) {
//            hh.add(i);
//        }

        /*
        java8中 如果一条链表的元素个数到达 TREEIFY_THRESHOLD(默认是8)
        并且table的大小 大于 MIN_TREEIFY_CAPAITY(默认是64)，就会进行树化（红黑树）
        否则依然采用数组扩容机制
         */
        //以下现实
        for (int i = 1; i <= 12; i++) {
            hh.add(new DA(i));
        }
        //只要增加一个元素 -》 node  就算增加一个{超过12个就可以扩容}
//        for (int i = 0; i < 8; i++) {
//            hh.add(new DB(i));
//        }
    }
}
//方便上面实现两个对象
class DA{
    private int n;

    public DA(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return "DA{" +
                "n=" + n +
                '}';
    }

    @Override
    public int hashCode() {
        return 100;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DA da = (DA) o;
        return n == da.n;
    }
}

class DB {
    private int m;

    public DB(int m) {
        this.m = m;
    }
    @Override
    public int hashCode() {
        return 200;
    }
}
