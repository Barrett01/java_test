package test01;

import java.util.Scanner;

/*
统计三个班级及格人数每个班级五名
 */
public class test05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        for (int i = 1;i<=2;i++){
            for (int j = 1 ;j<=3;j++ ){
                System.out.println("请输入"+ i+"班 第"+ j+"同学的成绩");
                double v = scanner.nextDouble();
                if (v >=60 ){
                    count++;
                }
                else {
                    System.out.println("不做统计");
                }
            }
        }
        System.out.println("及格人数为："+count);
        scanner.close();
    }
}
