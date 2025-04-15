package TestJiHe;

import java.util.Comparator;
import java.util.TreeSet;
/*
TreeSet的练习 已经源码追溯{底层调用的还是TreMap}
 */
public class TreeSet_ {
    public static void main(String[] args) {
        TreeSet set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
//                return ((String)o1).compareTo((String)o2);//比较字母
                return ((String) o1).length() - ((String) o2).length();//比较长度

            }
        });
        set.add("xhangsan");
        set.add("shanghai");
        set.add("hii");//3
        set.add("x");
        set.add("hsp");//3
        System.out.println(set);
    }
}
