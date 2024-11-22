package test02;

import java.util.Arrays;
import java.util.Scanner;

/*
迷宫问题
思路的话：
二维数组
写一个终点的坐标
输入一个初始位置 然后根据附件的往下跳着走 利用这个递归来一步步靠近重点


老师思路：
先规定map 数组的元素值：0 可以走； 1不可以走，表示障碍物


//总结：难点在于第一思路问题 ，没有想到用0，1，2，3，来表示坐标情况，导致难度增大；
第二，没有想象打印绘图情况
第三，缺少练习 对代码的掌握情况缺失；最重要的一点就是递归的掌握 还是不够熟练
 */
public class Migong {
    public static void main(String[] args) {

        int wangGe[][] = new int[8][7];
        for (int i = 0 ; i<=7 ;i++){
            wangGe[i][0] = 1;
            wangGe[i][6] = 1;
        }
        for (int i =1 ;i<=5;i++){
            wangGe[0][i] =1;
            wangGe[7][i] =1;
        }
        wangGe[2][1] = 1;
        wangGe[2][2] = 1;


        System.out.println("=========当前地图情况=======");
        for (int x = 0 ; x <= wangGe.length-1;x++){
            for (int y = 0 ; y <= wangGe[x].length-1; y++){
                System.out.print(wangGe[x][y]+"\t");
            }
            System.out.println();
        }

//调用方法
        Method method = new Method();
        boolean b = method.luJing(wangGe, 1, 1);
        System.out.println("=========路径地图情况=======");
        for (int x = 0 ; x <= wangGe.length-1;x++){
            for (int y = 0 ; y <= wangGe[x].length-1; y++){
                System.out.print(wangGe[x][y]+"\t");
            }
            System.out.println();
        }


    }
}

class Method{
//如果找到就返回true 找不到就返回false
//    0：可以走 1 表示障碍物 2 表示走的路线 3 表示走不通
    //wangGe[6][5] = 2表示走通了
    public boolean luJing(int[][] wangGe, int hang,int lie){
        if (wangGe[6][5] == 2){
            return true;
        }else {
            if (wangGe[hang][lie] == 0){
                wangGe[hang][lie] = 2;
                if (luJing(wangGe,hang+1,lie)){
                    return true;
                } else if (luJing(wangGe,hang,lie+1)) {
                    return  true;
                } else if (luJing(wangGe,hang,lie-1)) {
                    return true;
                } else if (luJing(wangGe,hang-1,lie)) {
                    return true;
                }else {
                    wangGe[hang][lie] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }
}