package TestChangYongLei;

import java.util.Scanner;

/*
String 《=》StringBuffer相互转换第二次练习
 */
public class StringBufferExercise02 {
    public static void main(String[] args) {
        String mp = "1230236.00";
        StringBuffer stringBuffer = new StringBuffer(mp);
        int i = stringBuffer.lastIndexOf(".");
        stringBuffer.insert(i-3,",");
        System.out.println(stringBuffer);
        //然后改进
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入：");
        String next = scanner.next();
        StringBuffer sb = new StringBuffer(next);
        for (int num = sb.lastIndexOf(".")-3;num>0;num-=3){

            sb.insert(num,",");
//            num=num-3;或者用在这里
        }
        System.out.println(sb);


    }
}
