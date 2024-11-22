package test01;

import java.util.Arrays;

/*
已知有个升序数组，要求插入一个元素，该数组依旧升序
 */
public class test15 {
    public static void main(String[] args) {
//        int array[] = new int[];
        int[] arr = {7,8,2,9,26};
        int inserNum = 6;
        PaiXu paiXu = new PaiXu();
        System.out.println(paiXu.insert(arr,inserNum));
    }
}

class PaiXu{
    public int[] insert(int arr[] , int inserNum){
        int xiaBNum = -1;
        Arrays.sort(arr);//数组排序
        System.out.println(Arrays.toString(arr));

        //通过下标来确定位置
        for (int i = 0 ;i< arr.length;i++){
            if (inserNum <= arr[i]){
                xiaBNum = i;
                break;
            }
        }
        if (xiaBNum == -1){
            xiaBNum = arr.length;
        }
        int[] b = new int[arr.length+1];
        for (int i = 0,j=0 ;i <b.length;i++){
            if (xiaBNum != i){
                b[i] = arr[j];
                j++;
            }else {
                b[i] = inserNum;
            }
        }

//        //直接插入{没走通 后续再看}
//        int num = 0;
//        for (int i = 0 ; i < arr.length;i++){
//            if (inserNum <= arr[i]){
//                b[i+1] = arr[i];
//                b[i] = inserNum;
//
//            }
//        }

//        //傻逼方法
//        b[(b.length-1)] = inserNum;
//        Arrays.sort(b);
        System.out.println(Arrays.toString(b));


        return b;
    }
}
