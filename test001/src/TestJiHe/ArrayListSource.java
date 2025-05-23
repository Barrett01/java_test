package TestJiHe;

import jdk.nashorn.internal.ir.CallNode;
//分析ArrayList的底层机制
import java.sql.Array;
import java.util.ArrayList;

public class ArrayListSource {
    public static void main(String[] args) {
        //使用无参构造器创建ArrayList对象
//        ArrayList list = new ArrayList();
        ArrayList list = new ArrayList(8);
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        for (int i = 11; i < 15; i++) {
            list.add(i);
        }
        list.add(100);
        list.add(200);
        list.add(null);
        for (Object o : list) {
            System.out.println(o);
        }
    }
}
