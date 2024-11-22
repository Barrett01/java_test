package test01;

import java.util.Arrays;

/*
随机生成10个整数（1-100） 保存到数组，并倒序打印以及求平均值 最大值 和最大值下标，
并找到到里面是否有8
 */
public class test17 {
    public static void main(String[] args) {
        int num = 0;
        double avg = 0;
        int max = 0;
        int maxfalg = 0;

        int array[] = new int[10];
        for (int i = 0 ; i<array.length;i++){
            array[i] = (int)(Math.random()*100);
            num += array[i];
        }
        System.out.println("平均值："+ num/10);


        for (int i = array.length-1 ;i>=0; i--){
            System.out.print(array[i]+"\t");
        }

        for (int i = 0 ; i<array.length-1 ; i++){
            if (array[i] > array[i+1]){
                max = array[i];
                array[i] = array[i+1];
//                array[i+1] = max;
                maxfalg = i;
            }
            if (array[i] == 8){
                System.out.println("里面有数字八");
            }
        }
        System.out.println(Arrays.toString(array));
        System.out.println("最大值："+max+"下标："+maxfalg);
    }
}
