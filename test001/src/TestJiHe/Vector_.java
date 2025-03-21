package TestJiHe;

import java.util.Vector;

public class Vector_ {
    public static void main(String[] args) {
//        Vector vector = new Vector();//通过断点不难发现，无参构造的时候 是10初始，然后就是二倍增长
        Vector vector = new Vector(8);//带参的话就以参数的二倍增长
        for (int i = 0; i < 10; i++) {
            vector.add(i);
        }
        System.out.println(vector);
        vector.add(100);
        System.out.println(vector);
    }
}
