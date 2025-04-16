package TestJiHe;

import java.util.*;

/*
Collections 工具类的常用方法
 */
public class Collections_ {
    public static void main(String[] args) {
        //创建ArrayList 集合 用于测试
        ArrayList list = new ArrayList();
        list.add("zs");
        list.add("wangwu");
        list.add("ls");
        list.add("hsp");
        list.add("huanghao");
        System.out.println("正常排序前：");
        System.out.println(list);


        //reverse(List):反转 List中元素的顺序
        Collections.reverse(list);
        System.out.println("反转排序后：");
        System.out.println(list);
        //shuffle(List) :对List 集合元素进行随机排序
        Collections.shuffle(list);
        System.out.println("打乱随机排序：");
        System.out.println(list);
        //sort(List):根据元素的自然顺序对指定List集合元素按升序排列
        Collections.sort(list);
        System.out.println("自然排序后：");
        System.out.println(list);
        //sort(List,Comparator):根据指定的Comparator 产生的顺序对List集合元素进行排序
        //这里希望按照字符串的长度大小排序
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).length() - ((String)o2).length();
            }
        });
        System.out.println("自定义比较字符串长度：");
        System.out.println(list);
        //swap(List,int,int):将指定List 集合中的i处元素和j处元素进行交换
        Collections.swap(list, 4, 0);
        System.out.println("交换元素之后：");
        System.out.println(list);

        //Object max(Collection)
        System.out.println("自然顺序的最大值：");
        System.out.println(Collections.max(list));
        //Object max(Collection,Comparator) /根据Comparator指定的顺序 返回给定集合中的最大元素
        Object max = Collections.max(list, new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o1).length() - ((String) o2).length();
            }
        });
        System.out.println("自定义的最长值：");
        System.out.println(max);
        //Object min(Collection)
        System.out.println("默认最小值：");
        System.out.println(Collections.min(list));
        //Object min(Collection Comparator)
        Object min = Collections.min(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((String) o1).length() - ((String) o2).length();
            }
        });
        System.out.println("自定义最短的：");
        System.out.println(min);
        //int frequency(Collection,object)
        System.out.println("指定元素出现的次数");
        System.out.println(Collections.frequency(list,"huanghao"));
        //void copy (List dest,List src)
        System.out.println("copy");
        ArrayList dest = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            dest.add("");
        }
        Collections.copy(dest, list);
        System.out.println("复制后的数组：");
        System.out.println(dest);
        //boolen replaceAll(List list,Object oldVal,Object newVal) 将所有的旧值 替换成新值
        Collections.replaceAll(list,"zs","zhangsan");
        System.out.println("将所有的旧值 替换成新值后：");
        System.out.println(list);

    }
}
