package test02;
/*
面相过程-零钱通
 */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//思路：化繁为简
/*
第一：先完成现实菜单。给出对应的提示
第二：完成零钱通明细功能
思路：1，可以吧收益入账和消费，报存到数组；2，可以使用对象；3，简单的话可以使用String拼接
 */

public class SmallChanageSys {
    public static void main(String[] args) {
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        String key = "";
        //第二：完成零钱通明细功能
        //思路：1，可以吧收益入账和消费，报存到数组；2，可以使用对象；3，简单的话可以使用String拼接
        String details = "-----------零钱通明细----------";

        //第三：完成收益入涨
        //思路 ：定义新的变量
        double money = 0;
        double balance = 0 ;
        Date date = null;
        SimpleDateFormat adf = new SimpleDateFormat("yyyy-MM-dd HH:mm");//用于日期格式化

        //第四：消费说明：
        String note = "";
        do{
            System.out.println("==========零钱通=========");
            System.out.println("\t\t\t\t1 零钱通明细");
            System.out.println("\t\t\t\t2 收益到账");
            System.out.println("\t\t\t\t3 消    费");
            System.out.println("\t\t\t\t4 退    出");

            System.out.println("请选择（1-4）:");
            key = scanner.next();

            //使用switch 分支
            switch (key){
                case "1":
                    System.out.println(details);
                    break;
                case "2":
                    while (true){
                        System.out.println("输入收益金额: ");
                        money = scanner.nextDouble();
                        //money的值需要校验一下

                            balance += money;
                            //拼接信息
                            date = new Date();
//                    System.out.println(adf.format(date));
                            details += "\n收益入账\t"+money+"\t"+adf.format(date)+"\t"+balance;
                            break;


                    }
                    break;


                case "3":
//                    System.out.println("3 消    费");
                    System.out.println("输入消费金额：");
                    money= scanner.nextDouble();
                    System.out.println("输入消费原因：");
                    note = scanner.next();
                    balance -= money;
                    date = new Date();
//                    System.out.println(adf.format(date));
                    details += "\n"+note+"\t-"+money+"\t"+adf.format(date)+"\t"+balance;

                    break;
                case "4":
                    System.out.println("4 退    出");
                    loop =false;
                    break;
                default:
                    System.out.println("选择有误，请重新输入");
                    break;
            }
        }while (loop);
        System.out.println("=====退出零钱通=======");
    }
}
