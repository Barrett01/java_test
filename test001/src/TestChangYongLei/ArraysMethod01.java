package TestChangYongLei;

import java.util.Arrays;
import java.util.Comparator;

//Arrays排序源码解读
public class ArraysMethod01 {
    public static void main(String[] args) {
        Integer[] integers = {1,0,8,-6};
        //使用Arrays的toStriong的方法来显示数组
        System.out.println(Arrays.toString(integers));
        //1,sort排序
        //2,因为数组是个引用类型，所以通过sort排序后，会直接影响integers
        //3,sort重载的，也可以通过传入一个接口Comparator，来实现自定义排序
        System.out.println("===========排序后============");
        Arrays.sort(integers);
        System.out.println(Arrays.toString(integers));

        System.out.println("============定制排序=============");
        //4，调用sort方法定制排序时候，传入两个参数（1）排序数组arr
        //（2）实现了Comparator接口的匿名内部类，要求实现compare方法
        /*

         */
        Integer[] arr = {8,88,-8,86,89,28};
        Arrays.sort(arr,new Comparator<Object>(){
            @Override
            public int compare(Object o1, Object o2) {
                Integer i1 = (Integer)o1;
                Integer i2 = (Integer)o2;
                return i1-i2;//i2-i1,从小到大或者从大到小
            }
        });
        System.out.println(Arrays.toString(arr));

    }
}
