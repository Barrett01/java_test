package test03;

import java.util.Scanner;

/*
二进制转十进制算法
方法一：使用Integer.parseInt()方法 将字符串转为整数
 */
public class Test0301 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入二进制：");
        String binNumber = scanner.next();
        int decimalNumber = Integer.parseInt(binNumber, 2);
        System.out.println("对应的十进制：" + decimalNumber);
    }
}
