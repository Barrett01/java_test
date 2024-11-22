package test01;
/*
某人有100元 每经过一次路口，需要缴费，规则如下：
当现金 >= 50 时，每次交5%
当现金 < 50时，每次交10；
计算该人可以经过多少次路口
 */
public class test07 {
    public static void main(String[] args) {
        double money = 100;
        int count = 0;
//        if (money >= 50){
//            money= money-(money*0.05);
//        }else if (money < 50){
//            money = money-10;
//        }
        while (money>=50){
            money -= money*0.05;
            count++;
        }
        while (money< 50 && money>10){
            money -= 10;
            count++;
        }
        System.out.println("可以通过："+count);
    }
}
