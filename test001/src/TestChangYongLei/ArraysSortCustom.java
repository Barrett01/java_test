package TestChangYongLei;

import java.util.Arrays;
import java.util.Comparator;

//实现冒泡排序还定制的排序，用来模拟sort
public class ArraysSortCustom {
    public static void main(String[] args) {
        int[] arr = {1, -1, 5, 8, 2, 6};
        //使用冒泡来完成排序
        bubble01(arr);
        System.out.println(Arrays.toString(arr));

        //冒泡+定制
        System.out.println("========定制化冒泡========");
        bubble02(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int i1 = (Integer) o1;
                int i2 = (Integer) o2;
                return i2 - i1;
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    //冒泡
    public static void bubble01(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    //冒泡+定制
    public static void bubble02(int[] arr, Comparator c) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (c.compare(arr[j], arr[j + 1]) > 0) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
