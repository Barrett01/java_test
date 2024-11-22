package test01;

import java.util.Scanner;

/*
根据行 列 字符打印 对应行数和列数的字符，比如：行：4 列：4 字符# ，
则打印相应的效果
 */
public class test19 {
    public static void main(String[] args) {
        char[][] c = new char[][]{
                {'1','a'},
                {'2','*'},
                {'3','#'}
        };
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入行：");
        int hang = scanner.nextInt();
        System.out.println("请输入列：");
        int lie = scanner.nextInt();
        System.out.println("打印："+ c[hang-1][lie-1]);
    }
}
