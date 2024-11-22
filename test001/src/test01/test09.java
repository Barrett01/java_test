package test01;

import java.util.Scanner;

/*
判断一个整数是否是 水仙花数 （其各个位上 数字立方和 等于其本身。153 = 1^3 +5^3+3^3）
 */
public class test09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入三位数的整数：");
        int i = scanner.nextInt();
        int ge = i%10;
        int shi = i/10%10;
        int bai = i/100;
        if (((ge*ge*ge)+(shi*shi*shi)+(bai*bai*bai)) == i){
            System.out.println(i +"是水仙花数");
        }else {
            System.out.println("不是水仙花数字");
        }

    }
}
