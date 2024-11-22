package test01;

import java.util.Arrays;

/*
手搓冒泡排序
 */
public class test16 {
    public static void main(String[] args) {
        int aray[] = {6,3,5,9,8,1};
        for (int i = 0 ;i <aray.length;i++){
            for (int j = 0; j <aray.length-1-i;j++){
                if(aray[j] > aray[j+1]){
                    int map = 0;
                    map = aray[j+1];
                    aray[j+1] = aray[j];
                    aray[j] = map;
                }
//                System.out.println(aray[j]);
            }
        }
        System.out.println(Arrays.toString(aray));
    }
}
