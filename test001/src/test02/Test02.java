package test02;
/*
请使用递归的方式 求出斐波那契数1，1，2，3，5，8，13.。。
给你一个整数n{第几个数字 }，求出它的对应的斐波那契数是多少
 */
public class Test02 {
    public static void main(String[] args) {
        T0 t = new T0();
        int i = t.fiBonacci(6);
        System.out.println(i);
    }
}

class T0{
    public int fiBonacci(int n){

            if (n <= 1){
                return  n;
            }
            return fiBonacci(n -1)+fiBonacci(n-2);


    }
}