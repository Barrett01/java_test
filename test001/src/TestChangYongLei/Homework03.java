package TestChangYongLei;

import java.io.PrintStream;

public class Homework03 {
    public static void main(String[] args) {
    String name = "Huang ran Hao";
    printName(name);
    }

    public static void printName(String str){
        if (str == null){
            System.out.println("str 不能为空");
            return;
        }
        String[] names = str.split(" ");
        if (!(names.length == 3)){
            System.out.println("输入的格式不是对，必须是三个字符串类型");
            return;
        }
        String format = String.format("%s,%s.%c", names[2], names[0], names[1].toUpperCase().charAt(0));
        System.out.println(format);
    }
}
